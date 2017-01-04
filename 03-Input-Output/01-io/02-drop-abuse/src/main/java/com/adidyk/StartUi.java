package com.adidyk;

import java.io.*;

public class StartUi {

    // main - input number from console
    public static void main(String[] args) throws IOException {
//        try (InputStreamReader isr = new InputStreamReader(System.in)) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String text = br.readLine();
            System.out.println(text);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "Cp866"));
 //       System.out.print("Input even or odd number: ");
  //      String text = br.readLine();
  //      byte[] buffer = text.getBytes();
  //      ByteStream bs = new ByteStream();
  //      boolean number = bs.isNumber(new ByteArrayInputStream(buffer));
  //      System.out.println("Even number: " + number);
    }

}
