package com.adidyk;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import static com.adidyk.Constant.*;

public class Client {

    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader br;
    private Command command;
    private MenuClient menu;
    private Socket socket;

    Client() throws IOException {
        this.socket = new Socket(InetAddress.getByName("127.0.0.1"), 5000);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.menu = new MenuClient(this.in, this.out);
        this.command = new Command();
    }

    private void start() throws IOException {
        this.connect();
        String string;
            do {
                menu.getway();
                string = this.br.readLine();
                this.out.writeUTF(string);
                command.setCommand(string);
                menu.select(command);
            } while (!"q".equals(string));
    }

    private void connect() throws IOException {
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
        this.menu.fillAction();
        this.command.setCommand(HELP);
        this.menu.select(this.command);
    }

    public static void main(String[] args) throws IOException {
        new Client().start();
    }
}


