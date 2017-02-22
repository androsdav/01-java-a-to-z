package com.adidyk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static com.adidyk.Constant.*;

public class Server {

    private DataInputStream in;
    private DataOutputStream out;
    private Command command;
    private MenuServer menu;
    private Socket socket;
    //private

    Server() throws IOException {
        this.socket = new ServerSocket(5000).accept();
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.menu = new MenuServer(this.in, this.out, new StringBuffer(String.valueOf(ROOT)));
        this.command = new Command();
    }

    private void start() throws IOException {
        this.connect();
        String string;
        do {
            menu.getWay();
            string = this.in.readUTF();
            command.setCommand(string);
            menu.select(command);
        } while (!"q".equals(string));
    }

    private void connect() throws IOException {
        this.out.writeUTF("-------------------------------------------------------------");
        this.out.writeUTF(" S E R V E R ver.1.00 ");
        this.out.writeUTF("-------------------------------------------------------------");
        this.menu.fillAction();
        this.command.setCommand(HELP);
        this.menu.select(this.command);
    }

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

}


