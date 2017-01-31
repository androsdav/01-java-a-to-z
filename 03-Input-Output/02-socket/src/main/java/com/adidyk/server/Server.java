package com.adidyk.server;

import java.io.File;
import java.util.Properties;

public class Server {

    public static void main(String[] arg) {

        System.out.println("Hello word !!!");
        Api api = new Api();

        String[] dir = api.showDir("dir");
        for (String temp : dir) {
            System.out.println(temp);
        }

        System.out.println();

        String[] dir1 = api.showDir("dir" +"/" +dir[3]);
        for (String dr : dir1) {
            System.out.println(dr);
        }

        System.out.println("--- Properties ---");
        Properties p = System.getProperties();
        System.out.println(p.getProperty("Version: "     +"java.version"));
        System.out.println(p.getProperty("Vendor :"      +"java.vendor"));
        System.out.println(p.getProperty("Vendor URL :"  +"java.vendor.url"));
        System.out.println(p.getProperty("Home: "        +"java.home"));
        System.out.println(p.getProperty("Version :"     +"java.class.version"));
        System.out.println(p.getProperty("Path :"        +"java.class.path"));
        System.out.println(p.getProperty("Name :"        +"os.name"));
        System.out.println(p.getProperty("OS arch :"     +"os.arch"));
        System.out.println(p.getProperty("OS version :"  +"os.version"));
        System.out.println(p.getProperty("File separ :"  +"file.separator"));
        System.out.println(p.getProperty("Path separ :"  +"path.separator"));
        System.out.println(p.getProperty("Line separ :"  +"line.separator"));
        System.out.println(p.getProperty("User name :"   +"user.name"));
        System.out.println(p.getProperty("User home :"   +"user.home"));
        System.out.println(p.getProperty("User dir :"    +"user.dir"));



        /*File[] file = api.showFile("dir");
        for(File temp : file) {
            System.out.println(temp);

        }*/





     /*   int port = 5000; // 1025 - 65535
        try {

            ServerSocket ss = new ServerSocket(port);
            System.out.println("Waiting for a client... ");
            Socket socket = ss.accept();
            System.out.println("Got a client: ");

            InputStream socketInStr = socket.getInputStream();
            OutputStream socketOutStr = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInStr);
            DataOutputStream out = new DataOutputStream(socketOutStr);

            String string = null;

            while (true) {
                 string = in.readUTF();
                 String row = "test";
                 System.out.println("Client sent now: " + string);
                 System.out.println("Server send back... ");
                 out.writeUTF(string.concat(row));
                 out.flush();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }
}
