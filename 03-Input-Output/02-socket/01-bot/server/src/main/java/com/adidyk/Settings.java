package com.adidyk;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Settings {

    private final Properties prop = new Properties();

    public void load(InputStream io) {
        try {
            this.prop.load(io);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prop.getProperty(key);
    }

    public void getAllKey() {
        Enumeration <?> e = this.prop.propertyNames();
        while(e.hasMoreElements()) {
            String key = (String)e.nextElement();
            String value = this.prop.getProperty(key);
            System.out.println(key +" = " +value);

        }
       /// Set<String> keys = this.prop.keySet();
       // for (Map.Entry<String, String> item : this.prop.entrySet()) {

        //}

    }

    public Properties getProp() {
        return this.prop;
    }

}
