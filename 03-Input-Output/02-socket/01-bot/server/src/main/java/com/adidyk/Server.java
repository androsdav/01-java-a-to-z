package com.adidyk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import static com.adidyk.Constant.*;

public class Server {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    //private Command command;
    //private MenuServer menu;
    private Settings setting;

    // Constructor
    private Server(Settings setting) {
        this.setting = setting;
    }

    // Constructor
    private Server(Socket socket) throws IOException {
        this.socket = socket;
    }

    // loadConfig - loading settings from file "app.properties"
    private void loadConfig() throws IOException {
        //Settings setting = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream app = loader.getResourceAsStream("app.properties");
            InputStream oracle = loader.getResourceAsStream("oracle.properties")) {
            this.setting.load(app);
            new Constant(this.setting);
            this.setting.load(oracle);
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
       this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
       this.out = new PrintWriter(this.socket.getOutputStream());
    }

    // connect - the result of connection server
    private void connect() throws IOException {
        this.out.print("\n ------------------------------------------------------------------");
        this.out.print("  S E R V E R");
        this.out.print(" ------------------------------------------------------------------");
        this.out.print("\n [Info]: server is connected ...");
        this.out.print(" [Info]: server has next console commands ...");
    }

    // work - working with client
    private void work() throws IOException {
        String question;
        do {
            question = in.readLine();
            out.println(question + "test");
        } while (!"quit".equals(question));
    }

    // main - just main ;)
    public static void main(String[] args) throws IOException {
        Settings setting = new Settings();
        new Server(setting).loadConfig();
        try (Socket socket = new ServerSocket(PORT).accept()) {
            new Server(socket).start();
        }
    }

}