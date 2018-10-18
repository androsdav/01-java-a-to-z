package com.adidyk.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import static com.adidyk.setup.Constant.ENTRY;
import static com.adidyk.setup.Constant.HREF;

/**
 * Class PurserSAX used for pursers xml file (dest.xml) and counts sum all fields.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.10.2018.
 * @version 1.0.
 */
public class PurserSAX extends DefaultHandler {

    /**
     * @param file - is pathname to file in format xml (dest.xml).
     */
    private final File dest;

    /**
     * @param sum - sum all fields.
     */
    private long sum;

    /**
     * @param log - link variable to object of class Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(ConvertXSQT.class);

    /**
     * PurserSAX - constructor.
     * @param dest - is pathname to file in format xml (dest.xml).
     */
    PurserSAX(File dest) {
        this.dest = dest;
    }

    /**
     * purserSAX - reads all information from xml-file (dest.xml) using SAX-purser.
     */
    void purserSAX() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(this.dest, this);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * startElement - override method from class DefaultHandler. Read all tags and tag
     * attributes for each tag.
     * @param url        - url (don`t use).
     * @param localName  - local name (don`t use).
     * @param qName      - tag name.
     * @param attributes - attributes xml-file.
     */
    @Override
    public void startElement(String url, String localName, String qName, Attributes attributes) {
        if (ENTRY.equals(qName)) {
            this.sum = this.sum + Integer.parseInt(attributes.getValue(HREF));
        }
    }

    /**
     * getSum - returns sum result.
     * @return - returns sum result.
     */
    long getSum() {
        return this.sum;
    }

}