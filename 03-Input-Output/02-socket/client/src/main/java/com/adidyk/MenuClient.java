package com.adidyk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuClient {
    private DataInputStream in;
    private DataOutputStream out;
    private Map<String, UserAction> actions = new HashMap<>();

        MenuClient(DataInputStream in, DataOutputStream out) {
            this.in = in;
            this.out = out;
        }

        void fillAction() {
            actions.put("cd", new ChangerDir());
            actions.put("dir", new ShowDir());
            actions.put("help", new Help());
        }

        void select(Command command) throws IOException {
            if (actions.containsKey(command.getKey())) {
                this.actions.get(command.getKey()).execute(command);
            } else {
                System.out.println("Command was false...");
            }
        }

        public void getway() throws IOException {
            String string = this.in.readUTF();
            System.out.print(" Server:" +string + "> ");
        }

        private class ChangerDir implements UserAction {
            // key - return "cd"
            public String key () {
                return "cd";
            }
            //changeDir - change folder: input one step, output one step, output to root directory
            public void execute(Command command) throws IOException {
            }
        }

        private class ShowDir implements UserAction {
            //
            public String key () {
                return "dir";
            }
            // showDir - return all folders and files that are in folder
            public void execute(Command command) throws IOException {
                int listDir = in.readInt();
                if (listDir != 0) {
                    for (int index = 0; index < listDir; index++) {
                        System.out.println(" --- " +in.readUTF());
                    }
                } else {
                    System.out.println("Folder do not have any think..");
                }
                System.out.println();
            }
        }

        private class Help implements UserAction {
            //
            public String key() {
                return "help";
            }
            //
            public void execute(Command command) throws IOException {
                for (int index = 0; index < actions.size(); index++) {
                    String string = in.readUTF();
                    System.out.println(string);
                }
                System.out.println();
            }
        }

}



