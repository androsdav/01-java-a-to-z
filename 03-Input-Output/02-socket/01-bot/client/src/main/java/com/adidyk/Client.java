package com.adidyk;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import static com.adidyk.Constant.*;

public class Client {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader console;
    private Bot bot;

    // Constructor
    private Client() throws IOException {
    }

    // Constructor
    private Client(Socket socket) throws IOException {
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
        this.console = new BufferedReader(new InputStreamReader(System.in));
        this.bot = new Bot(this.in);
    }

    // connect - the result of connection server
    private void connect() throws IOException {
        System.out.println(in.readUTF());
        System.out.println(in.readUTF());
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
    }

    // work - working with server
    private void work() throws IOException {
        String ask;
            do {
                System.out.println();
                System.out.print(" " + CLIENT + " ");
                ask = this.console.readLine();
                this.out.writeUTF(ask);
                this.bot.getAnswer();
            } while (!QUIT.equals(ask));
    }

    // main - just main ;)
    public static void main(String[] args) throws IOException {
        new Client().loadConfig();
        try (Socket socket = new Socket(InetAddress.getByName(IP), PORT)) {
            new Client(socket).start();
        }
    }

}