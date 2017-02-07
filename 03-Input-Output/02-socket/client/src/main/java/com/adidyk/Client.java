package com.adidyk;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        int port = 5000;
        String ip = "127.0.0.1";
        try {

//            InetAddress ip = InetAddress.getByName(address);
            Socket socket = new Socket(InetAddress.getByName(ip), port);

//            InputStream is = socket.getInputStream();
//            OutputStream os = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String command;

            do {
                System.out.println(" Input command ... ");
                command = br.readLine();
                out.writeUTF(command);
                command = in.readUTF();
                System.out.println(" Server send: " + command);
                //out.writeUTF("test result command ");
            } while ("q".equals(command));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


