package com.adidyk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.adidyk.Constant.*;

public class Server {

    private DataInputStream in;
    private DataOutputStream out;
    private Command command;
    private MenuServer menu;

    Server() throws IOException {
    }

    //
    private void start() throws IOException {
        this.loadConfig();
        this.init();
        this.connect();
        this.work();
    }

    //
    private void loadConfig() throws IOException {
        Settings setting = new Settings();
        File file = new File("src/main/resources/app.properties");
        try (FileInputStream fis = new FileInputStream(file)) {
            setting.load(fis);
            new Constant(setting);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    //
    private void init() throws IOException {
        Socket socket = new ServerSocket(PORT).accept();
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.menu = new MenuServer(this.in, this.out, new StringBuffer((ROOT)));
        this.command = new Command();
    }

    //
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

    //
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
        new Server().start();
    }

}


