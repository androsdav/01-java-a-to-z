package com.adidyk;

import java.io.*;

public class StartUi {

    // main - input row from console
    public static void main(String[] args) throws IOException {
        RemoveAbuse ra = new RemoveAbuse();
        String[] abuse = {"abuse1", "abuse2"};
        System.out.println("Input row: ");
        ra.dropAbuses(System.in, System.out, abuse);
    }


/*    do {
//            while (!(text = br.readLine()).equals("q")) {
        text = br.readLine();
        String[] args = text.split(" ");
        for (int arg = 0; arg < args.length; arg++) {
            for (String abu : abuse) {
                if (args[arg].equals(abu)) {
                    args[arg] = " ";
                }
            }
        }
        for (String arg : args) {
            bw.write(arg + " ");
        }

    }
    while (!text.equals("q"));
}
catch (Exception ex) {
        System.out.println(ex.getMessage());
        }

    */

}
