package com.adidyk;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        int port = 5000;
        String ip = "127.0.0.1";
        try {

//            InetAddress ip = InetAddress.getByName(address);
            Socket socket = new Socket(InetAddress.getByName(ip), port);

            InputStream is = socket.getInputStream();
//            OutputStream os = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            MenuClient menu = new MenuClient(in, out);
            menu.fillAction();

            String string;
            String way;

            do {
                menu.getway();
                //System.out.print(in.readUTF());
                string = br.readLine();
                out.writeUTF(string);
                Command command = new Command();
                command.setCommand(string);
                menu.select(command);
//                string = in.readUTF();
                //System.out.println(" Server send: " + command);
                //out.writeUTF("test result command ");
            } while (!"q".equals(string));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


