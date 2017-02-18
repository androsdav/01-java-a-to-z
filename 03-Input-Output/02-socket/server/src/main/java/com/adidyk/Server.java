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
    //private

    Server() throws IOException {
        Socket socket = new ServerSocket(5000).accept();
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.menu = new MenuServer(this.out, new StringBuffer(String.valueOf(ROOT)));
        this.command = new Command();
    }

    private void start() throws IOException {
        this.connect();
        //MenuServer menu = new MenuServer(this.out, new StringBuffer(String.valueOf("root")));
        //Command command = new Command();
        //menu.fillAction();
        //command.setCommand(HELP);
        //menu.select(command);
        String string;
        do {
            menu.getWay();
            string = this.in.readUTF();
            command.setCommand(string);
            menu.select(command);
        } while (!"q".equals(string));
    }

    private void connect() throws IOException {
        this.out.writeUTF(" Server commands ");
        this.menu.fillAction();
        this.command.setCommand(HELP);
        this.menu.select(this.command);
    }

    public static void main(String[] args) throws IOException {
        new Server().start();
        //new Server().connect();
    }

}


