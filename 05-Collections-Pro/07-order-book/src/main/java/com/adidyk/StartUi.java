package com.adidyk;

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
        System.out.println("Order-book");
        Order order = new Order("book-1", "buy", 100, 200, 1);
        //System.out.println(order);
        Book book = new Book();
        book.readerXML(new File("orders.xml"));
    }

}