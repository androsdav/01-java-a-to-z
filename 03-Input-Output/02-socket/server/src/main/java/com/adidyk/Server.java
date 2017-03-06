package com.adidyk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.adidyk.Constant.*;

public class Server {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Command command;
    private MenuServer menu;

    // Constructor
    Server(Socket socket) throws IOException {
        this.socket = socket;
    }

    // start - start to work with server
    private void start() throws IOException {
        this.init();
        this.connect();
        this.work();
    }

    // init - initialization parameters
    private void init() throws IOException {
        this.in = new DataInputStream(this.socket.getInputStream());
        this.out = new DataOutputStream(this.socket.getOutputStream());
        this.menu = new MenuServer(this.in, this.out, new StringBuffer((ROOT)));
        this.command = new Command();
    }

    // connect - the result of connection server
    private void connect() throws IOException {
        this.out.writeUTF("\n ------------------------------------------------------------------");
        this.out.writeUTF("  S E R V E R");
        this.out.writeUTF(" ------------------------------------------------------------------");
        this.out.writeUTF("\n [Info]: server is connected ...");
        this.out.writeUTF(" [Info]: server has next console commands ...");
        this.menu.fillAction();
        this.command.setCommand(HELP);
        this.menu.select(this.command);
    }

    // work - working with server
    private void work() throws IOException {
        String string;
        do {
            this.menu.getWay();
            string = this.in.readUTF();
            this.command.setCommand(string);
            this.menu.select(this.command);
        } while (!"q".equals(string));
    }

    // main - just main ;)
    public static void main(String[] args) throws IOException {
        // loading settings from file app.properties
        Settings setting = new Settings();
        File file = new File("src/main/resources/app.properties");
        try (FileInputStream fis = new FileInputStream(file)) {
            setting.load(fis);
            new Constant(setting);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        // creating object socket
        try (Socket socket = new ServerSocket(PORT).accept()) {
            new Server(socket).start();
        }
    }

}


