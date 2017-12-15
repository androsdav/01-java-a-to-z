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
     * @param book is link variable on object of class BookContainer.
     */
    private final BookContainer book;

    /**
     * @param file is pathname to file in format xml.
     */
    private final File file;

    /**
     *
     * @param book is link variable on object of class BookContainer.
     * @param file is pathname to file in format xml.
     */
    private StartUi(BookContainer book, File file) {
        this.book = book;
        this.file = file;

    }

    /**
     * start - run program.
     */
    private void start() {
        this.book.readerXML(this.file);
    }

    /**
     * main - is for create jar file and run program.
     * @param arg is nothing.
     */
    public static void main(String[] arg) {
        final BookContainer book = new BookContainer();
        final File orders = new File("orders.xml");
        new StartUi(book, orders).start();
    }

}