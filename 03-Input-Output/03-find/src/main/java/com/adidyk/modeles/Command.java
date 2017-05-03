package com.adidyk.modeles;

import java.util.Scanner;

public class Command {

    private String key;
    private String name;
    private String keyFind;

    public void setCommand(String string) {
        Scanner in = new Scanner(string);
        while (in.hasNext()) {
            if (in.hasNext()) {
                this.key = in.next();
            }
            if (in.hasNext()) {
                this.name = in.next();
            } else {
                this.name = null;
            }
            if (in.hasNext()) {
                this.keyFind = in.next();
            } else {
                this.keyFind = null;
            }
        }
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getKeyFind(){
        return this.keyFind;
    }

}