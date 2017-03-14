package com.adidyk;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
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

    public void test() {
        for (Map.Entry map : this.prs.entrySet()) {
            System.out.println(map.getKey());
            System.out.println(map.getValue());
        }
    }



}
