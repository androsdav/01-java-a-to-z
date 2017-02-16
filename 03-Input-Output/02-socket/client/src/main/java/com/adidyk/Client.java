package com.adidyk;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader br;

    Client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 5000);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void start() throws IOException {
        MenuClient menu = new MenuClient(this.in, this.out);
        Command command = new Command();
        menu.fillAction();
        command.setCommand("help");
        menu.select(command);
        String string;
            do {
                menu.getway();
                string = this.br.readLine();
                this.out.writeUTF(string);
                command.setCommand(string);
                menu.select(command);
            } while (!"q".equals(string));
    }

    public static void main(String[] args) throws IOException {
        new Client().start();
    }
}


