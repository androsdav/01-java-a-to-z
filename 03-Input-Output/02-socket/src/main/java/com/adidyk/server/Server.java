package com.adidyk.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] arg) {
        int port = 5000; // 1025 - 65535
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
        }
    }
}
