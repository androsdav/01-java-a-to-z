package com.adidyk;

//import java.io.File;

import java.io.File;

/**
 * Class "StartUi" for create jar file.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class StartUi {

    /**
     *
     */
    private final BookContainer book;

    /**
     *
     */
    private final File file;

    /**
     *
     * @param book is book.
     * @param orders is file.
     */
    private StartUi(BookContainer book, File orders) {
        this.book = book;
        this.file = orders;

    }

    /**
     *
     */
    private void start() {
        this.book.readerXML(this.file);
    }

    /**
     * main - is only for create jar file.
     * @param arg nothing.
     */
    public static void main(String[] arg) {
        final BookContainer book = new BookContainer();
        final File orders = new File("orders.xml");
        new StartUi(book, orders).start();
    }

}