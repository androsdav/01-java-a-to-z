package com.adidyk;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Settings {

    private final Properties prop = new Properties();
    private Map<String, String> questions = new HashMap<>();

    public void load(InputStream io) {
        try {
            this.prop.load(io);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setHashMap() {
        Enumeration<?> e = this.prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = this.prop.getProperty(key);
            System.out.println(key + " = " + value);
            this.questions.put(key, value);
        }
    }

    public String getValue(String key) {
        return this.prop.getProperty(key);
    }

    public void getAnswer(String question) {
        if (this.questions.containsKey(question)) {

        }
    }

            //System.out.println();
            //for (Map.Entry<String, String> question : this.questions.entrySet()) {
                //String string = item.
            //    System.out.println(question.getKey() +" = " +question.getValue());
           // }

       /// Set<String> keys = this.prop.keySet();
       // for (Map.Entry<String, String> item : this.prop.entrySet()) {

        //}

    }

    public Properties getProp() {
        return this.prop;
    }

}
