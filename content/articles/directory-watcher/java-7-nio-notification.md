---
title: "Java 7 NIO notification"
kind: article
created_at: 2012-04-19 22:22:22 +0000
author: "Takács Ottó"
published: true
book: directory-watcher
book_page: 4
---
##[Java 7 NIO notification](http://docs.oracle.com/javase/tutorial/essential/io/notification.html)

Igazából ide nincs milyen példát felhozni, hiszen csaknem ugyan az, mint a JPathwatch. Szinte csak az importokat kell lecserélni.

Jellemzője:

- java 7. Még friss és sokáig tipikusan a üzleti alkalmazásoknál nem fognak gyorsan váltani.
- alapból nem kezeli a rekurzív könyvtár vizsgálatot.
- a többi kb a JPathwatch-nál leírtak.

#### Rekurzív könyvtárvizsgálat

Ugyan alapbül nem támogatja, de azért természetesen megoldható. A [WatchDir.java](http://docs.oracle.com/javase/tutorial/essential/io/examples/WatchDir.java) példában következő módon:

~~~java
    /**
     * Register the given directory with the WatchService
     */
    private void register(Path dir) throws IOException {
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        if (trace) {
            Path prev = keys.get(key);
            if (prev == null) {
                System.out.format("register: %s\n", dir);
            } else {
                if (!dir.equals(prev)) {
                    System.out.format("update: %s -> %s\n", prev, dir);
                }
            }
        }
        keys.put(key, dir);
    }

    /**
     * Register the given directory, and all its sub-directories, with the
     * WatchService.
     */
    private void registerAll(final Path start) throws IOException {
        // register directory and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor&lt;Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException
            {
                register(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
~~~

További kapcsolódó linkek:

- [FolderListener for JDK7 – Watch folder events more elegantly.](http://whiteboardjunkie.wordpress.com/2012/01/26/folderlistener-for-jdk7-watch-folder-events-more-elegantly/)
- [FilesystemAlterationMonitor](http://commons.apache.org/jci/commons-jci-fam/index.html) Talán nem is ezzel megvalósítva, de a teljes képhez az a Apache Commons project is érdekes.
