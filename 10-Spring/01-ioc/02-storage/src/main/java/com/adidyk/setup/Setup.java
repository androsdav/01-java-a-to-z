package com.adidyk.setup;

import java.io.InputStream;
import java.util.Properties;

/**
 * Class of Setting use to load file from input stream and return parameter by key from file configure app.properties.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 04.09.2018.
 * @version 1.0.
 */
public class Setup {

    /**
     * @param prs - link variable to object of class Properties.
     */
    private final Properties prs = new Properties();

    /**
     * load - loads params from file app.properties.
     * @param io - link variable to object of class InputStream.
     */
    void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * getValue - returns parameter by key from file configure app.properties.
     * @param key - key fo returned parameter.
     * @return - returns parameter by key.
     */
    public String getValue(String key) {
        return this.prs.getProperty(key);
    }

}