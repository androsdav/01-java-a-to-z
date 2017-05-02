package com.adidyk.start;

import com.adidyk.modeles.Command;
import com.adidyk.modeles.Constant;
import java.io.IOException;
import static com.adidyk.modeles.Constant.*;

public class StartUi {

    private Input input;
    private Tracker tracker;
    private MenuTracker menu;
    private Command command;

    // Constructor
    private StartUi(Input input) {
        this.input = input;
    }

    // start - start program - SEARCH ENGINE
    private void start() throws IOException {
        this.init();
        this.connect();
        this.work();
    }

    // init - start initialization parameters
    private void init() {
        this.tracker = new Tracker();
        this.command = new Command();
        this.menu = new MenuTracker(this.input, this.tracker);
        new Constant();
    }

    // connect - welcome to SEARCH ENGINE, show program help, have to input correct path name
    private void connect() throws IOException {
        System.out.println("\n ------------------------------------------------------------------");
        System.out.println("  S E A R C H     E N G I N E");
        System.out.println(" ------------------------------------------------------------------");
        System.out.println("\n [Info]: SEARCH ENGINE has next console commands ... \n");
        this.menu.fillAction();
        this.command.setCommand(HELP);
        this.menu.select(this.command);
        String string;
        do {
            System.out.print("\n [Info]: input correct path name or folder name - [root] ...");
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
