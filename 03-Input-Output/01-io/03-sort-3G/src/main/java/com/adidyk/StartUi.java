package com.adidyk;

import java.io.*;

public class StartUi {

    // main - input several row from console, for finished input <q>
    public static void main(String[] args) throws IOException {
        SortFile sf = new SortFile();
        //File source = new File("source.txt");
        //File distance = new File("distance.txt");

        String source = "source.txt";
        String distance = "distance.txt";


        sf.sort(source, distance);

        System.out.print(File.separator);
        System.out.print(File.separatorChar);
        System.out.print(File.pathSeparator);
        System.out.print(File.pathSeparatorChar);

        /*

        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        try {
            byte buf[]=new byte[1024];
            int len;
            int count=0;
            while((len=inputStream.read(buf))>0){
                count++;
                out.write(len);
            }
            System.out.print("size: "+(count/1024)+"Mb");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            out.close();
            inputStream.close();
        }
    }



        */

        /*
        Допустим, у вас имеется n отсортированных файлов, которые надо слепить воедино.
        1. Открывайте FileStream на финальный файл
        2
4. Необходимо отсортировать файл по возрастанию длин строк, использовать внешнюю сортировку и RandomAccessFile.
        8. Если строчек больше нет, то закройте этот поток и удалите временный файл.
        9. Если все файлы были закрыты и удалены, то работа завершена, закройте поток в финальный файл.
        10. В противном случае goto 4.
        */
        //System.out.println(source.length());
        //System.out.println(source.getAbsoluteFile());
        //System.out.println(source.getAbsolutePath());
        //System.out.println(source.getParent());
        //System.out.println(source.getParentFile());
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