package com.adidyk;

import java.io.DataInputStream;
import java.io.IOException;
import static com.adidyk.Constant.*;

public class Bot {

    private DataInputStream in;

    // Constructor
    public Bot (DataInputStream in) {
        this.in = in;
    }

    // getAnswer - print answer (value) to console by question (key) if client set true key
    public void getAnswer(String ask) throws IOException {
        if (this.in.readBoolean()) {
            if (HELP.equals(ask)) {
                int size = in.readInt();
                System.out.println(this.in.readUTF() + "\n");
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
