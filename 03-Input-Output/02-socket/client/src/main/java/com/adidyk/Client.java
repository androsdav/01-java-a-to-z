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

    private Client() throws IOException {
    }

    //
    private void start() throws IOException {
        this.loadConfig();
        this.init();
        this.connect();
        this.work();
    }

    // loadConfig -
    private void loadConfig() throws IOException {
        Settings setting = new Settings();
        File file = new File("src/main/resources/app.properties");
        try (FileInputStream fis = new FileInputStream(file)) {
            setting.load(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        new Constant(setting);
    }

    // init -
    private void init() throws IOException {
        Socket socket = new Socket(InetAddress.getByName(IP), PORT);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.menu = new MenuClient(this.in, this.out);
        this.command = new Command();
    }

    // connect -
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

    // work -
    private void work() throws IOException {
        String string;
            do {
                menu.getway();
                string = this.br.readLine();
                this.out.writeUTF(string);
                command.setCommand(string);
                menu.select(command);
            } while (!"q".equals(string));
    }

    //
    public static void main(String[] args) throws IOException {
        new Client().start();
    }
}


