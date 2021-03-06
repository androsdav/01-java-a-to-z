package com.adidyk;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.adidyk.Constant.*;


public class Bot {

    private Map<String, String> oracle = new HashMap<>();
    private DataOutputStream out;

    // Constructor
    public Bot(DataOutputStream out) {
        this.out = out;
    }

    // loadAskAnswer - loads questions (keys) and answer (values) to HashMap -> " param = this.oracle "
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
            this.oracle.put(key, value);
        }
    }

    // getAnswer - returns answer (value) by question (key) if client set true key
    public void getAnswer(String ask) throws IOException {
        if (this.oracle.containsKey(ask)) {
            this.out.writeBoolean(true);
            if (HELP.equals(ask)) {
                this.out.writeInt(this.oracle.size());
                this.out.writeUTF(" " + SERVER + " " + this.oracle.get(ask));
                for (Map.Entry<String, String> item : this.oracle.entrySet()) {
                    this.out.writeUTF("   - " + item.getKey());
                }
            } else {
                this.out.writeUTF(" " + SERVER + " " + this.oracle.get(ask));
            }
        } else {
            this.out.writeBoolean(false);
            this.out.writeUTF(" " + SERVER + " ");
        }
    }

}

