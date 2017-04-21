package com.adidyk.start;

import com.adidyk.modeles.Command;

public class StartUi {

    //private Input input;



    //private StartUi(Input input) {

        //this.input = input;

    //}


//    private void start() {



    public static void main(String[] arg) {

        Command com = new Command();
        com.setCommand("key1 name1 key2");
        System.out.println(com.getKey());
        System.out.println(com.getName());
        System.out.println(com.getKeyFind());

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
