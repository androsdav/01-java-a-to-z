package com.adidyk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private DataInputStream in;
    private DataOutputStream out;

    Server() throws IOException {
        Socket socket = new ServerSocket(5000).accept();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    private void start() throws IOException {
        MenuServer menu = new MenuServer(this.out, new StringBuffer(String.valueOf("root")));
        Command command = new Command();
        menu.fillAction();
        command.setCommand("help");
        menu.select(command);
        String string;
        do {
            menu.getWay();
            string = this.in.readUTF();
            command.setCommand(string);
            menu.select(command);
        } while (!"q".equals(string));
    }

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

}


