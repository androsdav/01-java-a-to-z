package com.adidyk;

import java.io.*;

public class StartUi {

    // main - input row from console
    public static void main(String[] args) throws IOException {
        RemoveAbuse ra = new RemoveAbuse();
        String[] abuse = {"abuse"};
        System.out.println("Input row : ");
        ra.dropAbuses(System.in, System.out, abuse);
    }

}
