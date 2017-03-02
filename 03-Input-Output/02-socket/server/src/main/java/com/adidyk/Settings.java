package com.adidyk;

import java.io.InputStream;
import java.util.Properties;

public class Settings {

    private final Properties prs = new Properties();


    public void load(InputStream io) {
        try {
            this.prs.load(io);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }


}
