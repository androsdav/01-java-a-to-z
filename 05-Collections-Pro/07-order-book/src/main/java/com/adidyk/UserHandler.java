package com.adidyk;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Class UserHandle.
 */
public class UserHandler extends DefaultHandler {

    /**
     * @param addOrder is order.
     */
    private boolean addOrder;

    /**
     * @param uri is uri.
     * @param localName is localName.
     * @param qName is qName.
     * @param attributes is attributes.
     * @throws SAXException is return exception.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("AddOrder".equals(qName)) {
            //String book = attributes.getValue("book");
            //String operation = attributes.getValue("operation");
            //String price = attributes.getValue("price");
            //String volume = attributes.getValue("volume");
            //String orderId = attributes.getValue("orderId");
            this.addOrder = true;
        }
    }

    /**
     * @param uri is.
     * @param localName is.
     * @param qName is.
     * @throws SAXException is.
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("AddOrder".equals(qName)) {
            System.out.println("End Element :" + qName);
        }
    }

    /**
     * @param ch is.
     * @param start is.
     * @param length is.
     * //@throws SAXException is.
     */
    @Override
    public void characters(char ch[], int start, int length) {
        if (this.addOrder) {
            System.out.println("First Name: " + new String(ch, start, length));
        }
    }

}

