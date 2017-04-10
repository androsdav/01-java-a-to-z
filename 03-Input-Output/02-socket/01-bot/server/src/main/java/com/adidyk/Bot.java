package com.adidyk;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Bot {

    private Map<String, String> oracle = new HashMap<>();
    private DataOutputStream out;

    public Bot(DataOutputStream out) {
        this.out = out;
    }

    public void loadAskAnswer() {
        Properties prop = new Properties();
        try(InputStream is = getClass().getClassLoader().getResourceAsStream("oracle.properties")) {
            prop.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            System.out.println(key + " = " + value);
            this.oracle.put(key, value);
        }
    }

    public void getAnswer(String ask) throws IOException {
        if (this.oracle.containsKey(ask)) {
            this.out.writeBoolean(true);
            this.out.writeUTF(this.oracle.get(ask));
        } else {
            this.out.writeBoolean(false);
        }


    }

}

