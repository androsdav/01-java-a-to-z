package com.adidyk;

public class StartUi {

    private Input input;



    private StartUi(Input input) {

        this.input = input;

    }


    private void start() {

    }

    public static void main(String[] arg) {
        //System.out.println("Test, Hello Word");

        //new Filter();
        //Filter.init();
        // test git
        Input input = new ConsoleInput();
        new StartUi(input).start();
        Find find = new Find();
        find.find("root");
    }

}
