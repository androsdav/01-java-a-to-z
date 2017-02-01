package com.adidyk.server;

import java.io.File;
import java.util.Properties;

public class Server {

    public static void main(String[] arg) {

        System.out.println("Hello word !!!");
        Api api = new Api();

        String[] dir = api.enterDir("dir");
        for (String temp : dir) {
            System.out.println(temp);
        }

        System.out.println();

        Properties prop = System.getProperties();
        String separator = prop.getProperty("file.separator");

        String[] dir1 = api.enterDir("temp0");
        for (String dr : dir1) {
            System.out.println(dr);
        }

        /*System.out.println("--- Properties ---");
        Properties p = System.getProperties();
        System.out.println("Version : " +p.getProperty("java.version"));
        System.out.println("Vendor :" +p.getProperty("java.vendor"));
        System.out.println("Vendor URL :" +p.getProperty("java.vendor.url"));
        System.out.println("Home: " +p.getProperty("java.home"));
        System.out.println("Version :" +p.getProperty("java.class.version"));
        System.out.println("Path :" +p.getProperty("java.class.path"));
        System.out.println("Name :" +p.getProperty("os.name"));
        System.out.println("OS arch :" +p.getProperty("os.arch"));
        System.out.println("OS version :" +p.getProperty("os.version"));
        System.out.println("File separ :" +p.getProperty("file.separator"));
        System.out.println("Path separ :" +p.getProperty("path.separator"));
        System.out.println("Line separ :" +p.getProperty("line.separator"));
        System.out.println("User name :" +p.getProperty("user.name"));
        System.out.println("User home :" +p.getProperty("user.home"));
        System.out.println("User dir :" +p.getProperty("user.dir"));


*/

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
