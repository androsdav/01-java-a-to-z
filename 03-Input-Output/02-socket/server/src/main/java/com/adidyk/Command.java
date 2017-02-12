package com.adidyk;

import java.util.Scanner;

public class Command {

    private String key;
    private String name;

    public void setCommand(String string) {
        Scanner in = new Scanner(string);
        while (in.hasNext()) {
            if (in.hasNext()) {
                this.key = in.next();
            }
            if (in.hasNext()) {
                this.name = in.next();
            }

        }
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }
}
