package com.adidyk;

import java.io.File;

/**
 * Class StartUi for create jar file and run program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class StartUi {

    /**
     * @param book - is link variable on object of class Book.
     */
    private final Book book;

    /**
     * @param file - is pathname to file in format xml.
     */
    private final File file;

    /**
     * @param book - is link variable on object of class Book.
     * @param file - is pathname to file in format xml.
     */
    private StartUi(Book book, File file) {
        this.book = book;
        this.file = file;

    }

    /**
     * start - run program, uses User-purser and SAX-purser.
     */
    private void start() {
        this.book.readerUser(this.file);
        this.book.readerSAX(this.file);
    }

    /**
     * main - is for create jar file and run program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        final Book book = new Book();
        final File orders = new File("orders.xml");
        new StartUi(book, orders).start();
    }

}