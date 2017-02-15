package com.adidyk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuClient {
    private DataInputStream in;
    private DataOutputStream out;
    //private StringBuffer way;

       // private static final String SEPARATOR = System.getProperty("file.separator");
       // private static final String ROOT = "root";
       // private static final String FROM = "..";
        private Map<String, UserAction> actions = new HashMap<>();

        MenuClient(DataInputStream in, DataOutputStream out) {
            this.in = in;
            this.out = out;
//            this.way = root;
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
                System.out.println("Key is false");
            }
        }

        private class ChangerDir implements UserAction {
            // key - return "cd"
            public String key () {
                return "cd";
            }
            //changeDir - change folder: input one step, output one step, output to root directory
            public void execute(Command command) throws IOException {
               String string = in.readUTF();
                System.out.println(string + "<client test>");
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
                String string = in.readUTF();
                System.out.println(string +"<client test>");
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
                String string = in.readUTF();
                System.out.println(string +"<client test>");
            }
            //
            public String info() {
                return String.format("Its  help");
            }
        }


}



