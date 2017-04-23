package com.adidyk.start;

import com.adidyk.modeles.Command;

import java.io.IOException;

public class StartUi {

    private Input input;
    private Tracker tracker;
    private MenuTracker menu;

    Command command;

    StartUi(Input input) {
        this.input = input;
    }


    //private Input input;



    //private StartUi(Input input) {

        //this.input = input;

    //}



//    private void start() {

    private void start() throws IOException {
        this.init();
        this.work();
    }

    private void init() {
        this.tracker = new Tracker();
        this.command = new Command();
        this.menu = new MenuTracker();
    }

    private void connect() {
        System.out.println();
    }

    private void work() throws IOException {
        String string;
        do {
            System.out.println("Path: " + this.tracker.getPath());
            string = this.input.ask();
            this.command.setCommand(string);
            this.menu.select(this.command);

        } while(!"quit".equals(string));
    }

    public static void main(String[] arg) throws IOException {

        Input input = new ConsoleInput();

        new StartUi(input).start();

        //Command com = new Command();
        //com.setCommand("key1 name1 key2");
        //System.out.println(com.getKey());
        //System.out.println(com.getName());
        //System.out.println(com.getKeyFind());

        //Tracker tracker = new Tracker();
        //tracker.setPath("g:/");

        //System.out.println("Test, Hello Word");

        //new Filter();
        //Filter.init();
        // test git
  //      Input input = new ConsoleInput();
   //     new StartUi(input).start();
   //     Find find = new Find();
   //     find.find("root");
    }

}
