package com.adidyk;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashMap;
import static com.adidyk.Constant.BUY;
import static com.adidyk.Constant.SELL;
import static com.adidyk.Constant.ADD_ORDER;
import static com.adidyk.Constant.DELETE_ORDER;

/**
 * --------------------------------------------------------------------------------------------------------------
 * Class PurserSAXr contains a container for storing orders.
 * Container is HashMap that contains books. Each book contains two HashMap - sell and buy.
 * HashMap sell and buy contains object of class Order (value) and key, where key is id of object of class Order.
 * --------------------------------------------------------------------------------------------------------------
 * Class PurserUser has next method:
 * -> purserUser - reads first line (one order) from file and calls method to addOrder or delOrder
 *                 depending on the type order, after that reads second line (one order) and loop is repeated
 *                 while lines will not finished;
 * -> addOrder   - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                 (SELL or BUY) in map and adds new order to map by id order;
 * -> delOrder   - do searches needed book (book-1 or book-2 or book-3) in map, after that do searches needed operation
 *                 (SELL or BUY) in map and remove order from map by id order.
 * -> purse      - purse one string, creates new object of class Order and returns new object.
 * -> getBook    - returns reference variable to book.
 * --------------------------------------------------------------------------------------------------------------
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class PurserSAX extends DefaultHandler {

    /**
     * @param book - link variable on container HashMap<String, HashMap<String, HashMap<Integer, Order>>>.
     */
    private final HashMap<String, HashMap<String, HashMap<Integer, Order>>> book = new HashMap<>();

    /**
     * @param file - is pathname to file in format xml.
     */
    private final File file;

    /**
     * PurserSAX - constructor.
     * @param file - is pathname to file in format xml.
     */
    PurserSAX(File file) {
        this.file = file;
    }

    /**
     * purserSAX - reads all information from xml-file using SAX-purser.
     */
    void purserSAX() {
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
     * @param uri - is uri (don`t use).
     * @param localName - is local name (don`t use).
     * @param qName - is name xml-file.
     * @param attributes - is attributes xml-file (don`t use).
     * @throws SAXException - exception SAX-purser.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (ADD_ORDER.equals(qName)) {
            String book = attributes.getValue("book");
            String operation = attributes.getValue("operation");
            Double price = Double.valueOf(attributes.getValue("price"));
            Integer volume = Integer.valueOf(attributes.getValue("volume"));
            Integer orderId = Integer.valueOf(attributes.getValue("orderId"));
            final Order order = new Order(book, operation, price, volume, orderId);
            this.addOrder(order);
        }
        if (DELETE_ORDER.equals(qName)) {
            String book = attributes.getValue("book");
            Integer orderId = Integer.valueOf(attributes.getValue("orderId"));
            final Order order = new Order(book, null, 0, 0, orderId);
            this.delOrder(order);
        }
    }

    /**
     * addOrder - do searches needed book (book-1 or book-2 or book-3) in map, after that do
     * searches needed operation (SELL or BUY) in map and adds new order to map by id order.
     * @param order - is one object of class Order from one tag from xml-file.
     */
    private void addOrder(Order order) {
        this.book.computeIfAbsent(order.getBook(), k -> new HashMap<>());
        this.book.get(order.getBook()).computeIfAbsent(order.getOperation(), k -> new HashMap<>());
        this.book.get(order.getBook()).get(order.getOperation()).put(order.getId(), order);
    }

    /**
     * delOrder - do searches needed book (book-1 or book-2 or book-3) in map, after that do
     * searches needed operation (SELL or BUY) in map and remove order from map by id order.
     * @param order - is one object of class Order from one tag from xml-file.
     */
    private void delOrder(Order order) {
        this.book.get(order.getBook()).get(SELL).remove(order.getId());
        this.book.get(order.getBook()).get(BUY).remove(order.getId());
    }

    /**
     * getBook - returns reference variable to book.
     * @return - returns reference variable to book.
     */
    public HashMap<String, HashMap<String, HashMap<Integer, Order>>> getOrder() {
        return this.book;
    }

}