package com.adidyk;

import java.io.*;

public class StartUi {

    // main - input several row from console, for finished input <q>
    public static void main(String[] args) throws IOException {
        SortFile sf = new SortFile();
        File source = new File("source.txt");
        File dist = new File("dist.txt");


        sf.sort(source);
        System.out.println(source.length());
        System.out.println(source.getAbsoluteFile());
        System.out.println(source.getAbsolutePath());
        System.out.println(source.getParent());
        System.out.println(source.getParentFile());
    }
}

         /*   try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt")))
            {
                // чтение построчно
                String text;
                while(!(text = br.readLine()).equals("ESC")){

                    bw.write(text);
                    bw.flush();
                }
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    } */
        //SortFile sf = new SortFile();
        //File source = new File("source.txt");
        //File dist = new File("dist");
        //sf.sort(source);
        //System.getProperty("user.dir");
       /* RemoveAbuse ra = new RemoveAbuse();
        String[] abuse = {"abuse1", "abuse2", "abuse3"};
        String text;
        String row = "";
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Input several row, for finished input <q>: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (!(text = br.readLine()).equals("q")) {
            list.add(text);
        }
        br.close();
        for (String arg : list) {
            row = row.concat(arg).concat(" ");
        }
        ra.dropAbuses(new ByteArrayInputStream(row.getBytes()), System.out, abuse);*/