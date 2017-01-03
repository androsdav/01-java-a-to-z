package com.adidyk;

//import java.io.*

import java.io.*;

public class StartUi {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "Cp866"));
        System.out.print("Input even or odd number: ");
        String text = br.readLine();
        byte[] buffer = text.getBytes();
        ByteStream bs = new ByteStream();
        boolean number = bs.isNumber(new ByteArrayInputStream(buffer));
        System.out.println(number);
    }

}
