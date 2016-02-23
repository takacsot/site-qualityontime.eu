import groovy.io.FileType


long lastModified = 0
File dir = new File('./content')

while (true){
  //println "checking..."
  long max = 0;
  dir.eachFileRecurse (FileType.FILES) { file ->
    if(max < file.lastModified())
      max = file.lastModified()
  }
  if(lastModified < max){
    recompile()
    lastModified = max
  }

  Thread.sleep(3000)
}

def recompile(){
  println  "recompile ${new Date()}"
  def proc = "c:\\environment\\apps\\ruby-1.9.3\\bin\\nanoc.bat  compile".execute()
  println proc.text
}