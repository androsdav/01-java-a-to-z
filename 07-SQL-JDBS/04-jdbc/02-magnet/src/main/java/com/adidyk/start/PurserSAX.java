package com.adidyk.start;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashMap;

/**
 * --------------------------------------------------------------------------------------------------------------
 * Class PurserSAX contains a container for storing orders.
 * Container is HashMap that contains books. Each book contains two HashMap - sell and buy.
 * HashMap sell and buy contains object of class Order (value) and key, where key is id of object of class Order.
 * --------------------------------------------------------------------------------------------------------------
 * Class PurserSAX has next method:
 * -> purserSAX    - reads first line (one order) from file and calls method to addOrder or delOrder
 *                   depending on the type order, after that reads second line (one order) and loop is repeated
 *                   while lines will not finished;
 * -> startElement - override method from class DefaultHandler. Read all tags (add or delete) and tag
 *                   attributes for each tag, added or delete tag;
 * -> addOrder     - do searches needed book (book-1 or book-2 or book-3) in map, after that do
 *                   searches needed operation (SELL or BUY) in map and adds new order to map by id order.
 * -> delOrder     - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 * -> getBook      - returns reference variable to book.
 * --------------------------------------------------------------------------------------------------------------
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class PurserSAX extends DefaultHandler {

    /**
     * @param file - is pathname to file in format xml.
     */
    private final File file;

    private int sum;

    /**
     * PurserSAX - constructor.
     *
     * @param file - is pathname to file in format xml.
     */
    public PurserSAX(File file) {
        this.file = file;
    }

    /**
     * purserSAX - reads all information from xml-file using SAX-purser.
     */
    public void purserSAX() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(this.file, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * startElement - override method from class DefaultHandler. Read all tags (add or delete) and tag
     * attributes for each tag, added or delete tag.
     *
     * @param uri        - is uri (don`t use).
     * @param localName  - is local name (don`t use).
     * @param qName      - is name xml-file.
     * @param attributes - is attributes xml-file (don`t use).
     * @throws SAXException - exception SAX-purser.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("entry".equals(qName)) {
            int entry = Integer.parseInt(attributes.getValue("href"));
            System.out.println(entry);
            sum = sum + entry;
        }
    }

    public void print() {
        System.out.println(sum);
    }

}