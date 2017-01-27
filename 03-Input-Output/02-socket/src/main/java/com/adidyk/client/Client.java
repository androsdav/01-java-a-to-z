package com.adidyk.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        int serverPort = 5000;
        String interAdress = "127.0.0.192";

        try {
            InetAddress inetAddress = InetAddress.getByName(interAdress);
            System.out.println("Connecting to the server..." + serverPort);
            Socket socket = new Socket(inetAddress, serverPort);

            InputStream socketInStr = socket.getInputStream();
            OutputStream socketOutStr = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInStr);
            DataOutputStream out = new DataOutputStream(socketOutStr);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = null;
            System.out.println("Input phrase for send: ");

            while (true) {
                string = reader.readLine();
                out.writeUTF(string);
                out.flush();
                string = in.readUTF();
                System.out.println("Server sent message: " + string);
                System.out.println("Input phrase for send: ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
