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
import static com.adidyk.Constant.ADDORDER;
import static com.adidyk.Constant.DELETEORDER;

/**
 * Class UserHandle.
 */
public class PurserSAX extends DefaultHandler {

    /**
     * @param book - link variable on container HashMap<String, HashMap<String, HashMap<Integer, Order>>>.
     */
    private final HashMap<String, HashMap<String, HashMap<Integer, Order>>> book = new HashMap<>();

    /**
     * @param file is pathname to file in format xml.
     */
    private final File file;

    /**
     * UserHandle - constructor.
     * @param file is file.
     */
    PurserSAX(File file) {
        this.file = file;
    }

    /**
     * reader SAX is SAX.
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
     * @param uri is uri.
     * @param localName is localName.
     * @param qName is qName.
     * @param attributes is attributes.
     * @throws SAXException is return exception.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (ADDORDER.equals(qName)) {
            String book = attributes.getValue("book");
            String operation = attributes.getValue("operation");
            Double price = Double.valueOf(attributes.getValue("price"));
            Integer volume = Integer.valueOf(attributes.getValue("volume"));
            Integer orderId = Integer.valueOf(attributes.getValue("orderId"));
            final Order order = new Order(book, operation, price, volume, orderId);
            this.addOrder(order);
        }
        if (DELETEORDER.equals(qName)) {
            String book = attributes.getValue("book");
            Integer orderId = Integer.valueOf(attributes.getValue("orderId"));
            final Order order = new Order(book, null, 0, 0, orderId);
            this.delOrder(order);
        }
    }

    /**
     * addOrder - do searches needed book (book-1 or book-2 or book-3) in map, after that do
     * searches needed operation (SELL or BUY) in map and adds new order to map by id order.
     * @param order is one string from xml-file.
     */
    private void addOrder(Order order) {
        this.book.computeIfAbsent(order.getBook(), k -> new HashMap<>());
        this.book.get(order.getBook()).computeIfAbsent(order.getOperation(), k -> new HashMap<>());
        this.book.get(order.getBook()).get(order.getOperation()).put(order.getId(), order);
    }

    /**
     * delOrder  - do searches needed book (book-1 or book-2 or book-3) in map, after that do
     * searches needed operation (SELL or BUY) in map and remove order from map by id order.
     * @param order is one string from xml-file.
     */
    private void delOrder(Order order) {
        this.book.get(order.getBook()).get(SELL).remove(order.getId());
        this.book.get(order.getBook()).get(BUY).remove(order.getId());
    }

    /**
     * getBook - returns book.
     * @return is book.
     */
    public HashMap<String, HashMap<String, HashMap<Integer, Order>>> getOrder() {
        return this.book;
    }

}