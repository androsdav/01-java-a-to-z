package com.adidyk.start;

import com.adidyk.modeles.Command;
import java.io.IOException;

public class StartUi {

    private Input input;
    private Tracker tracker;
    private MenuTracker menu;
    private Command command;

    private StartUi(Input input) {
        this.input = input;
    }

    // start -
    private void start() throws IOException {
        this.init();
        this.connect();
        this.work();
    }

    // init -
    private void init() {
        this.tracker = new Tracker();
        this.command = new Command();
        this.menu = new MenuTracker(this.input, this.tracker);
    }

    // connect -
    private void connect() throws IOException {
        System.out.println("\n ------------------------------------------------------------------");
        System.out.println("  S E A R C H     E N G I N E");
        System.out.println(" ------------------------------------------------------------------");
        System.out.println("\n [Info]: search engine has next console command ...");
        this.menu.fillAction();
        this.command.setCommand("help");
        this.menu.select(this.command);
        String string;
        do {
            System.out.print("\n [Info]: input correct name path or <root> directory ...");
            System.out.print("\n [Path]: " + "> ");
            string = this.input.ask();
            this.command.setCommand(string);
            this.menu.select(this.command);
        } while(tracker.getPath() == null);
    }

    // work -
    private void work() throws IOException {
        String string;
        do {
            System.out.print("\n [Path]: " + this.tracker.getPath() + "> ");
            string = this.input.ask();
            this.command.setCommand(string);
            this.menu.select(this.command);
        } while(!"quit".equals(string));
    }

    // main - just main ;)
    public static void main(String[] arg) throws IOException {
        Input input = new ConsoleInput();
        new StartUi(input).start();
    }

}
