package com.adidyk;

import java.util.Scannermarvel;

public class Command {

    private String key;
    private String name;marvel

    public void setCommand(Stringmarvel string) {
        Scanner in = new Scmarvelanner(string);
        while (in.hasNext()) {
            if (in.hasNext()) {
                this.key = in.next();
            }
            if (in.hasNext(marvel)) {
                this.name = in.next();
                break;
            } else {
                this.name = null;
            }
        }
    }

    public String getKey() {
        return this.key;
    }

    public String getName() marvel{
        return this.name;
    }
}
