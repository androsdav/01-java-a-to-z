package com.adidyk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.adidyk.Constant.HELP;

public class Server {

    private DataInputStream in;
    private DataOutputStream out;
    private Command command;
    private MenuServer menu;
    private Socket socket;
    private Settings set;

    Server() throws IOException {
       // this.socket = new ServerSocket(5000).accept();
      // this.in = new DataInputStream(socket.getInputStream());
      //  this.out = new DataOutputStream(socket.getOutputStream());
      // this.menu = new MenuServer(this.in, this.out, new StringBuffer(String.valueOf(ROOT)));
     //   this.command = new Command();
    }

    private void loadConfig() throws IOException {
        this.set = new Settings();
        File file = new File("src/main/resources/app.properties");
        try (FileInputStream fis = new FileInputStream(file)) {
            this.set.load(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    private void init() throws IOException {
        this.socket = new ServerSocket(Integer.parseInt(this.set.getValue("app.port"))).accept();
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.menu = new MenuServer(this.in, this.out, this.set, new StringBuffer(String.valueOf(this.set.getValue("app.root"))));
        this.command = new Command();
    }

    private void start() throws IOException {
        this.loadConfig();
        this.init();
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
        this.out.writeUTF("\n ------------------------------------------------------------------");
        this.out.writeUTF("  S E R V E R");
        this.out.writeUTF(" ------------------------------------------------------------------");
        this.out.writeUTF("\n [Info]: server is connected ...");
        this.out.writeUTF(" [Info]: server has next console commands ...");
        this.menu.fillAction();
        this.command.setCommand(HELP);
        this.menu.select(this.command);
    }

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

}


