---
title: "Archive comparison"
kind: article
created_at: 2014-03-24 00:00:00 +0000
---

Épp a minap futottam bele egy igen nehéz JBoss és classloader problémába. 
Persze mi voltunk a hibásak, de azért elvitte az egész napot, amíg megtaláltuk a probléma forrását.

A gond az volt, hogy egy `EAR` filon belül azegyik `WAR` tartalmazott egy extra és felesleges log4j jar-t, ami a classloader sajátosságai miatt nem talált configurációt (noha a JBoss jól volt globálisan beállítva) és emiatt az alapértelmezett beállításokat használta, ami minden debug szinten tolt ki. És beleérte valami thirdparty komponest is, ami teljesen kiakasztotta a rendszert. A megoldás az lett, hogy ear shared library szintre hoztuk a log4j jar-t (pontosabban már ott volt, csak a war-ból kellett kegyomlálni). A végén csak egy kis pom file bűvészkedés volt a megoldás.

És hogyan kerüljük el a hasonló problémákat a jövőben? Az a stratégia, hogy a fejlesztés végén a "before" és "after" ear fájlokat üsszehasonlítjuk és a változások alapján rábólintunk, vagy megnézzük még egy alkalommal.

A munka dandárját egy olyan kis utility végzi, ami hierarchikusan kicsomagolja az egymásba ágyazott zip állományokat.

~~~java
import groovy.io.FileType

import java.security.MessageDigest

File.metaClass.extension {
  path.substring(path.lastIndexOf(".") + 1)
}
File.metaClass.isZip {
  ["zip", "ear", "war"].contains(extension())
}

def LeftFile = /c:\environment\_work\ZipComparison\x\LeftFile.zip/
def RightFile = /c:\environment\_work\ZipComparison\x\RightFile.zip/

Map leftHashes = generateHash(cleanup(unzip(new File(LeftFile))))
Map rightHashes = generateHash(cleanup(unzip(new File(RightFile))))
Map diff = mapDiff(leftHashes, rightHashes)
printReport(diff)


def unzip(File path) {
  if (!path.isZip()) {
    return path
  }
  File destination = new File(path.path + ".dir")
  if (destination.exists())
    destination.deleteDir()
  destination.mkdirs()
  def ant = new AntBuilder()
  ant.project.getBuildListeners().firstElement().setMessageOutputLevel(1)
  ant.unzip(src: path.path,
      dest: destination.path,
      overwrite: "false")

  destination.eachFileRecurse(FileType.FILES) { File child ->
    unzip(child)
  }
  return destination
}

def cleanup(File file) {
  file.eachFileRecurse(FileType.FILES) { File f ->
    if (f.isZip()) {
      f.delete()
    }
  }
  return file;
}

def generateHash(File dir) {
  Map hashes = [:]
  dir.eachFileRecurse(FileType.FILES) { File file ->
    def md = generateMD5(file)
    hashes[file.path.substring(dir.path.length() + 1)] = md
  }
  hashes
}

def generateMD5(final File file) {
  MessageDigest digest = MessageDigest.getInstance("MD5")
  file.withInputStream() { is ->
    byte[] buffer = new byte[8192]
    int read = 0
    while ((read = is.read(buffer)) > 0) {
      digest.update(buffer, 0, read);
    }
  }
  byte[] md5sum = digest.digest()
  BigInteger bigInt = new BigInteger(1, md5sum)
  return bigInt.toString(16).padLeft(32, '0')
}


def mapDiff(Map oldMap, Map newMap) {
  def newKeys = newMap*.key
  def oldKeys = oldMap*.key

  def removedKeys = oldKeys - newKeys
  def addedKeys = newKeys - oldKeys
  def commonKeys = newKeys - removedKeys - addedKeys
  def changedKeys = commonKeys.findAll { oldMap[it] != newMap[it] }
  def unchangedKeys = commonKeys - changedKeys

  def changes = [
      removed: oldMap.findAll { it.key in removedKeys },
      added: newMap.findAll { it.key in addedKeys },
      changed: oldMap.findAll { it.key in changedKeys },
      unchanged: newMap.findAll { it.key in unchangedKeys }
  ]
}

private void printReport(Map diff) {
  println "Only In Left"
  println "============"
  diff["removed"].each {
    println it.key
  }
  println "Only In Right"
  println "============"
  diff["added"].each {
    println it.key
  }
  println "Changed"
  println "============"
  diff["changed"].each {
    println it.key
  }
}
~~~
