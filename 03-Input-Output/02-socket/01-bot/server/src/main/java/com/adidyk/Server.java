package com.adidyk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import static com.adidyk.Constant.*;

public class Server {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Bot bot;

    // Constructor
    private Server() {
    }

    // Constructor
    private Server(Socket socket) throws IOException {
        this.socket = socket;
    }

    // loadConfig - loading settings from file "app.properties"
    private void loadConfig() throws IOException {
        Settings setting = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream app = loader.getResourceAsStream("app.properties")) {
            setting.load(app);
            new Constant(setting);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
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
       this.bot = new Bot(this.out);
       this.bot.loadAskAnswer();
    }

    // connect - the result of connection server
    private void connect() throws IOException {
        this.out.writeUTF("\n ------------------------------------------------------------------");
        this.out.writeUTF("  S E R V E R - B O T");
        this.out.writeUTF(" ------------------------------------------------------------------");
        this.out.writeUTF("\n [Info]: server - bot is connected ...");
        this.out.writeUTF(" [Info]: server - bot knows next:");
        this.out.writeUTF("\n [help] - return all question which server - bot knows ");
        this.out.writeUTF(" [quit] - disconnect from the server - bot");
    }

    // work - working with client
    private void work() throws IOException {
        String ask;
        do {
            ask = this.in.readUTF();
            bot.getAnswer(ask);
        } while (!QUIT.equals(ask));
    }

    // main - just main ;)
    public static void main(String[] args) throws IOException {
        new Server().loadConfig();
        try (Socket socket = new ServerSocket(PORT).accept()) {
            new Server(socket).start();
        }
    }

}