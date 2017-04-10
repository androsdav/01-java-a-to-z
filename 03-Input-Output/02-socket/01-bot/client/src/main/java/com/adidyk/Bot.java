package com.adidyk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Bot {

    private DataInputStream in;
    private DataOutputStream out;

    public Bot (DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void getAnswer() throws IOException {
        String answer = this.in.readUTF();
        if (answer != null) {
            System.out.println(answer);
        } else {
            System.out.println("I do not know answer for your ask ... ");
        }
    }
}
