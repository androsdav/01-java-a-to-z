package com.adidyk;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

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

    public Properties getProperties () {
        return this.prop;

    }

    public void test() {
        for (Map.Entry map : this.prop.entrySet()) {
            System.out.println(map.getKey() +" " + map.getValue());
            //System.out.println(map.getValue());
        }
    }



}
