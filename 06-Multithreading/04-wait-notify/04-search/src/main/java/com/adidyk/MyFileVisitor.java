package com.adidyk;

//import java.io.IOException;
import java.nio.file.FileVisitResult;
//import java.nio.file.Files;
//import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.CONTINUE;

/** Class StartUi for create jar file and run program (Locker).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.04.2018.
 * @version 1.0.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {

    /**
     *
     * @param file - is.
     * @param attr - is.
     * @return - is.
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        if (attr.isSymbolicLink()) {
            System.out.format("Symbolic link: %s ", file);
        } else if (attr.isRegularFile()) {
            System.out.format("Regular file: %s ", file);
        } else {
            System.out.format("Other: %s ", file);
        }
        System.out.println("(" + attr.size() + "bytes)");
        return CONTINUE;
    }

    /*
    /**
     * @param partOfName - is.
     */
    /*
    private String partOfName;

    /**
     * @param partOfContent - is.
     */
    /*
    private String partOfContent;

    /**
     * @param file - is.
     * @param attrs - is.
     * @return - is.
     * @throws IOException - is.
     */
    /*
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;
        if(partOfName!=null && !file.getFileName().toString().contains(partOfName)) {
            containsName = false;
        }
        String content = new String(Files.readAllBytes(file));
        boolean containsContent = true;
        if(partOfContent != null && !content.contains(partOfContent)) {
            containsContent = false;
        }
        if(containsName && containsContent) {
            foundFiles.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
*/
}
