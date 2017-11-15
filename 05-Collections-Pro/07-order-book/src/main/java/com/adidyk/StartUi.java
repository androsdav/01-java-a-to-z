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
        System.out.println("Order-book");
        System.out.println();
//        Order order = new Order("book-1", "buy", 100, 200, 1);
//        String string = "<AddOrder book=\"book-3\" operation=\"BUY\" price=\" 99.50\" volume=\"86\" orderId=\"2\" />";
        Book book = new Book();
        book.readerXML(new File("orders.xml"));
//        System.out.println(book);
        book.view();
      //  book.view1();
        //System.out.println(book.getSize());
        //String temp = "<AddOrder test";
        //System.out.println("TETS : " + temp.startsWith("<A"));

       // String test = "" + 's' + 'd' + 'a';
       // System.out.println(test);

       // char ch = 'U';
       // char ch1 = 'F';
       // String str = "" + ch + ch1;
       // System.out.println("Converting Char to String using String concatenation: " + str);


        //System.out.println(order);
        //Book book = new Book();
        //book.readerXML(new File("orders.xml"));
    }

}