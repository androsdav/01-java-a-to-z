package com.adidyk;


import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * StartUiTest.
 */
public class StartUiTest {

    /**
     * @param args is.
     */
    public static void main(String[] args) {

        try {
            File inputFile = new File("orders-test.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler1 userhandler = new UserHandler1();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * UserHandler.
 */
class UserHandler1 extends DefaultHandler {

    /**
     * is.
     */
    private boolean bFirstName = false;
    /**
     * is.
     */
    private boolean bLastName = false;
    /**
     * is.
     */
    private boolean bNickName = false;
    /**
     * is.
     */
    private boolean bMarks = false;

    /**
     *
     * @param uri is.
     * @param localName is.
     * @param qName is.
     * @param attributes is.
     * @throws SAXException is.
     */
    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("student")) {
            String rollNo = attributes.getValue("rollno");
            System.out.println("Roll No : " + rollNo);
        } else if (qName.equalsIgnoreCase("firstname")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("lastname")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("nickname")) {
            bNickName = true;
        } else if (qName.equalsIgnoreCase("marks")) {
            bMarks = true;
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
        if (qName.equalsIgnoreCase("student")) {
            System.out.println("End Element :" + qName);
        }
    }

    /**
     * @param ch is.
     * @param start is.
     * @param length is.
     * @throws SAXException is.
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bFirstName) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLastName = false;
        } else if (bNickName) {
            System.out.println("Nick Name: " + new String(ch, start, length));
            bNickName = false;
        } else if (bMarks) {
            System.out.println("Marks: " + new String(ch, start, length));
            bMarks = false;
        }
    }
}