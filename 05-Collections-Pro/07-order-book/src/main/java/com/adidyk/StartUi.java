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
     * main - is only for create jar file.
     * @param arg nothing.
     */
    public static void main(String[] arg) {
        System.out.println();
        BookContainer book = new BookContainer();
        book.readerXML(new File("orders1.xml"));
    }

}