package com.adidyk;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MenuServer {

    private DataOutputStream out;
    private StringBuffer way;

    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String ROOT = "root";
    private static final String FROM = "..";
    private Map<String, UserAction> actions = new HashMap<>();

    MenuServer(DataOutputStream out, StringBuffer root) {
        this.out = out;
        this.way = root;
    }

    void fillAction() {
        actions.put("cd", new ChangerDir());
        actions.put("dir", new ShowDir());
        actions.put("help", new Help());
    }

    void select(Command command) throws IOException {
        if (actions.containsKey(command.getKey())) {
            System.out.println("Key is true");
            this.actions.get(command.getKey()).execute(command);
        } else {
            out.writeUTF("Key is false");
        }
    }

    private class ChangerDir implements UserAction {
        // key - return "cd"
        public String key () {
            return "cd";
        }
        //changeDir - change folder: input one step, output one step, output to root directory
        public void execute(Command command) throws IOException {
            String directory = command.getName();
            if (directory == null) {
                way = new StringBuffer(ROOT);
            }
            else if (FROM.equals(directory)) {
                way = new StringBuffer(new File(String.valueOf(way)).getParent());
            } else {
                File dir = new File(String.valueOf(way));
                boolean dirFound = false;
                for (String list : dir.list()) {
                    if (directory.equals(list)) {
                        way = way.append(SEPARATOR).append(directory);
                        dirFound = true;
                        break;
                    }
                }
                if (!dirFound) {
                    System.out.println("Exception: -> Direct no found ");
                }
            }
            out.writeUTF(String.valueOf(way));
        }
        // info - return info about method execute
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Change folder.");
        }
    }

    private class ShowDir implements UserAction {
        //
        public String key () {
            return "dir";
        }
        // showDir - return all folders and files that are in folder
        public void execute(Command command) throws IOException {
            File file = new File(String.valueOf(way));
            String[] listDir = file.list();
            out.writeUTF(Arrays.toString(listDir));
        }
        // info -
        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Show folder.");
        }
    }

    private class Help implements UserAction {
        //
        public String key() {
            return "help";
        }
        //
        public void execute(Command command) throws IOException {
            out.writeUTF("There can be your advertising");
            //out.writeUTF("There can be your advertising");
        }
        //
        public String info() {
            return String.format("Its  help");
        }
    }


}

//    private class OutputFromDir implements UserAction {

//      public String key () {
//          return "cd";
//     }

//    public void execute(Api api, String row) throws IOException {
//        out.writeUTF(api.outputFromDir());
// }

// info - menu item " Show all item."
//        public String info() {
//            return String.format(" %s%s%s", this.key(), ".", " Show all item.");
//        }

//  }
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





