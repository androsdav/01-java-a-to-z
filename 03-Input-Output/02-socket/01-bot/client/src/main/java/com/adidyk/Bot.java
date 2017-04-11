package com.adidyk;

import java.io.DataInputStream;
import java.io.IOException;

public class Bot {

    private DataInputStream in;

    public Bot (DataInputStream in) {
        this.in = in;
    }

    public void getAnswer() throws IOException {
        if (this.in.readBoolean()) {
            System.out.println(this.in.readUTF());
        } else {
            System.out.println(" " + this.in.readUTF() + "I don`t know answer  for your ask ... ");
        }
    }

}
