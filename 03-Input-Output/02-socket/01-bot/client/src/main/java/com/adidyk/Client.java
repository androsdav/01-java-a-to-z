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
        //this.menu = new MenuClient(this.in, this.out);
        //this.command = new Command();
    }

    // connect - the result of connection server
    private void connect() throws IOException {
        System.out.println(in.readUTF());
        System.out.println(in.readUTF());
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
        System.out.println(this.in.readUTF());
        //this.menu.fillAction();
        //this.command.setCommand(HELP);
        //this.menu.select(this.command);
    }

    // work - working with server
    private void work() throws IOException {
        String string;
            do {
                System.out.print(CLIENT);
                string = this.console.readLine();
                this.out.writeUTF(string);
                //this.out.println(string);
                //string = this.in.readLine();
                //System.out.println(string);
                //while (!(string = this.in.readLine()).isEmpty()) {
                //    System.out.println(string);
               // }

              //  menu.getway();
              //  string = this.br.readLine();
              //  this.out.writeUTF(string);
              //  command.setCommand(string);
              //  menu.select(command);
            } while (!"quit".equals(string));
    }

    // main - just main ;)
    public static void main(String[] args) throws IOException {
        new Client().loadConfig();
        try (Socket socket = new Socket(InetAddress.getByName(IP), PORT)) {
            new Client(socket).start();
        }
    }

}