package com.adidyk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    Server() {

    }

    public static void main(String[] args) {

        int port = 5000; // 1025 - 65535
        //Api api = new Api(new StringBuffer("root"));
        MenuApi mApi = new MenuApi(new Api(new StringBuffer(String.valueOf("root"))));
        mApi.fillAction();
        try {
            System.out.println(" Waiting connect Client ... ");
            Socket socket = new ServerSocket(port).accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String command;
            do {
                System.out.println(" Wait command ... ");
                command = in.readUTF();
                mApi.select(command);
                System.out.println(" I have command: " + command);
                out.writeUTF(command +" " +"test");
                //out.writeUTF("test2");
            } while (!"q".equals(command));


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

        /*
        //---------------------------------------------------------------------------------------------
        // Test method from class Api
        Api api = new Api(new StringBuffer("root"));

        System.out.println();
        System.out.println(" Step 1 - in");
        String way1 = api.cdIn("temp0");
        System.out.println(" Way : " + way1);
        for (String dir : api.dir()) {
            System.out.println(" -- " + dir);
        }

        System.out.println();
        System.out.println("Step 2 - in");
        String way2 = api.cdIn("temp1");
        System.out.println(" Way : " + way2);
        for (String dir : api.dir()) {
            System.out.println(" -- " + dir);
        }

        System.out.println();
        System.out.println("Step 3 - in");
        String way3 = api.cdIn("libraries");
        System.out.println(" Way : " + way3);
        for (String dir : api.dir()) {
            System.out.println(" -- " + dir);
        }

        System.out.println();
        System.out.println(" Step 4 - out");
        String way4 = api.cdOut();
        System.out.println(" Way : " + way4);
        for (String dir : api.dir()) {
            System.out.println(" -- " + dir);
        }

        System.out.println();
        System.out.println(" Step 5 - out");
        String way5 = api.cdOut();
        System.out.println(" Way : " + way5);
        for (String dir : api.dir()) {
            System.out.println(" -- " + dir);
        }

        System.out.println();
        System.out.println(" Step 6 - out");
        String way6 = api.cdOut();
        System.out.println(" Way : " + way6);
        for (String dir : api.dir()) {
            System.out.println(" -- " + dir);
        }

        System.out.println();
        System.out.println("Step 7 - in");
        String way7 = api.cdIn("temp4");
        System.out.println(" Way : " + way7);
        for (String dir : api.dir()) {
            System.out.println(" -- " + dir);
        }

        System.out.println();
        System.out.println("Step 8 - in");
        String way8 = api.cdIn("temp51");
        System.out.println(" Way : " + way8);
        for (String dir : api.dir()) {
            System.out.println(" -- " + dir);
        }
        //---------------------------------------------------------------------------------------------
        */





/*
                 // create hash map
                HashMap<String, String> newmap = new HashMap<String, String>();
                // populate hash map
                newmap.put("1", "tutorials");
                newmap.put("2", "point");
                newmap.put("3", "is best");
                // get keyset value from map
                Set keyset = newmap.keySet();
        for (String key : newmap.keySet()) {
            if ("2".equals(key)) {
                System.out.println("Print: " +newmap.get(key));
            }
  //          System.out.println("Key : " +key);
        }

                // check key set values
//                System.out.println("Key set values are: " + keyset);
            }
        }*/
    /*    System.out.println();
        System.out.println(" Step 1");
        String way1 = api.cdIn("temp0");
        System.out.println(" Way : " +way1);
        for (String dir : api.dir()) {
            System.out.println(" -- " +dir);
        }


        System.out.println();
        System.out.println("Step 2");
        String way2 = api.cdIn("temp1");
        System.out.println(" Way : " +way2);
        for (String dir : api.dir()) {
            System.out.println(" -- " +dir);
        }

        System.out.println();
        System.out.println(" Step 3");
        String way3 = api.cdOut();
        System.out.println(" Way : " +way3);
        for (String dir : api.dir()) {
            System.out.println(" -- " +dir);*/

   /*     Api api = new Api(new StringBuffer("root"));

        int port = 5000; // 1025 - 65535
        try {
            System.out.println(" Waiting connect Client ... ");
            Socket socket = new ServerSocket(port).accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String command;
            do {
                System.out.println(" Wait command ... ");
                command = in.readUTF();
                api.cdIn(command, out);
                System.out.println(" I have command: " + command);
                //out.writeUTF("test1");
                //out.writeUTF("test2");
            } while (!"q".equals(command));


        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

*/


/*        Api api = new Api(new StringBuffer("root"));

        System.out.println();
        System.out.println(" Step 1");
        String way1 = api.cdIn("temp0");
        System.out.println(" Way : " +way1);
        for (String dir : api.dir()) {
            System.out.println(" -- " +dir);
        }


        System.out.println();
        System.out.println("Step 2");
        String way2 = api.cdIn("temp1");
        System.out.println(" Way : " +way2);
        for (String dir : api.dir()) {
            System.out.println(" -- " +dir);
        }

        System.out.println();
        System.out.println(" Step 3");
        String way3 = api.cdOut();
        System.out.println(" Way : " +way3);
        for (String dir : api.dir()) {
            System.out.println(" -- " +dir);
        } */



    /*private Input input;
    private Api api;

    Server(Input input) {
        this.input = input;
        this.api = new Api(new StringBuffer("root"));
    }

    private void init() {
        MenuApi menu = new MenuApi(this.input, this.api);
        menu.fillAction();
        while(true) {
            menu.show();
            int key = valueOf(input.ask(" Choose key: "));
            menu.select(key);
            if (key == 9) break;
        }
    }

    // main - just main :)
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new Server(input).init();
    }
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
                                            //      String row = "test";
                 System.out.println("Client sent now: " + string);
                 System.out.println("Server send back... ");
                 out.writeUTF(string.concat(row));
                 out.flush();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }*/




      /*  StringBuffer root = new StringBuffer("root");
        Api api = new Api(root);

        System.out.println("Step 1");
        String[] dir1 = api.enterDir("temp0");
        for (String dir : dir1) {
            System.out.println("  --- " +dir);
        }

        System.out.println("Step 2");
        String[] dir2 = api.enterDir("temp1");
        for (String dir : dir2) {
            System.out.println("  --- " +dir);
        }

        System.out.println("Step 3");
        String[] dir3 = api.exitDir();
        for (String dir : dir3) {
            System.out.println("  --- " +dir);
        }

        System.out.println("Step 4");
        String[] dir4 = api.exitDir();
        for (String dir : dir4) {
            System.out.println("  --- " +dir);
        }

        System.out.println("Step 5");
        String[] dir5 = api.enterDir("temp4");
        for (String dir : dir5) {
            System.out.println("  --- " +dir);
        }

        System.out.println("Step 6");
        String[] dir6 = api.enterDir("temp5");
        for (String dir : dir6) {
            System.out.println("  --- " +dir);
        }

        System.out.println("Step7");
        String[] dir7 = api.enterDir("temp6");
        for (String dir : dir7) {
            System.out.println("  --- " +dir);
        }

        System.out.println("Step8");
        String[] dir8 = api.enterDir("temp7");
        for (String dir : dir8) {
            System.out.println("  --- " +dir);
        }*/


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

