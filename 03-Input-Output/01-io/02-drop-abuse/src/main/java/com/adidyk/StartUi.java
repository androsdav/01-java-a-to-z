package com.adidyk;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StartUi {

    // main - input row from console
    public static void main(String[] args) throws IOException {
        RemoveAbuse ra = new RemoveAbuse();
        String[] abuse = new String[2];
        abuse[0] = "abuse1";
        abuse[1] = "abuse2";
        System.out.println("Input row: ");
        String text;
        ArrayList<String> list= new ArrayList<>();
        System.out.println("Input several row, for finished input <q>: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (!(text = br.readLine()).equals("q")) {
            list.add(text);
        }
        br.close();
        ArrayList<Byte> buffer = list.ge
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);


        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {


                do {
                    text = br.readLine();
                    byte[] buffer = text.getBytes();
                    //ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
                } while(true);
                ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
                ra.dropAbuses(bais, System.out, abuse);

            }
            while (!text.equals("q"));


            /*ra.dropAbuses(row, System.out, abuse);
                System.out.println("Input <q> for exit ");
                exit = br.readLine();
            }
            while (exit.equals("q"));*/

        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
