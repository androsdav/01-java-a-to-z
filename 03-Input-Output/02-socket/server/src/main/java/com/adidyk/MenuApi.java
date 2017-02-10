package com.adidyk;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuApi {

    private Api api;
    DataOutputStream out;
//    private String str;
    private Map<String, UserAction> actions = new HashMap<>();

    public MenuApi(Api api, DataOutputStream out) {
        this.api = api;
        this.out = out;
  //      this.str = str;
    }

    public void fillAction() {
        actions.put("cd", new InputToDir());
        actions.put("cd..", new OutputFromDir());
        actions.put("dir", new ShowDir());
    }

    public void select(String string) throws IOException {
        String[] key = string.split(" ");
        if (actions.containsKey(key[0])) {
            System.out.println("Key is true");
            this.actions.get(key).execute(this.api, key[1]);
        } else {
            System.out.println("Key is false");
        }
    }

    private class InputToDir implements UserAction {

        public void execute(Api api, String row) throws IOException {
            out.writeUTF("Its class InputToDir");
            //System.out.println("Its class InputToDir");
        }
    }

    private class OutputFromDir implements UserAction {

        public void execute(Api api, String row) throws IOException {
            //System.out.println("Its class OutputFromDir");
            out.writeUTF("Its class OutputFromDir");
        }

    }

    private class ShowDir implements UserAction {
        public void execute(Api api, String row) throws IOException {
            //System.out.println("Its class ShowDir");
            out.writeUTF("Its class ShowDir");
        }
    }


}
   /* public int temp = 0;

    private Api api;
    private Input input;
    private UserAction[] actions = new UserAction[3];


    //
    MenuApi(Input input, Api api) {
        this.input = input;
        this.api = api;
    }

    //
    protected void fillAction() {
        this.actions[0] = new CdIn();
        this.actions[1] = new CdOut();
        this.actions[2] = new Dir();
    }

    //
    protected void select(int key) {
        this.actions[key - 1].execute(this.input, this.api);
    }

    public void show() {
        System.out.println();
//        System.out.println("Way :" + this.api.getWay());
        System.out.println(" ------------------------------Server Menu --------------------------------");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    //
    private class CdIn implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(String str, Api api) {
            //String nameDir = input.ask(" Input name directory: ");
            String way = api.cdIn(str);
            }

        @Override
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Enter Dir.");
        }
    }

    //
    private class CdOut implements UserAction {
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(String str, Api api) {
            String way = api.cdOut();

        }

        @Override
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Exit Dir.");
        }
    }

    private class Dir implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(String str, Api api) {
            String[] listdir = api.dir();
        }

        @Override
        public String info() {
            return null;
        }
    }
}
/*
    private class Disconnect implements UserAction {
        @Override
        public int key() {
            return 3;
        }
        @Override
        public void execute(Input input, Api api) {
        }
        @Override
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Exit Dir.");
        }
    }*/
