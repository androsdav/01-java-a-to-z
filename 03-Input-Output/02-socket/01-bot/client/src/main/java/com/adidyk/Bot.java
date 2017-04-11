package com.adidyk;

import java.io.DataInputStream;
import java.io.IOException;

import static com.adidyk.Constant.HELP;
import static com.adidyk.Constant.NOT;

public class Bot {

    private DataInputStream in;

    public Bot (DataInputStream in) {
        this.in = in;
    }

    public void getAnswer(String ask) throws IOException {
        if (this.in.readBoolean()) {
            if (HELP.equals(ask)) {
                int size = in.readInt();
                System.out.println(this.in.readUTF());
                for (int index = 0; index < size; index++) {
                    System.out.println(this.in.readUTF());
                }
            } else {
                System.out.println(this.in.readUTF());
            }
        } else {
            System.out.println(this.in.readUTF() + NOT);
        }
    }

}
