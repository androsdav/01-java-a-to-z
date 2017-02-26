package com.adidyk;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static com.adidyk.Constant.SIZE;

public class MenuClient {
    private DataInputStream in;
    private DataOutputStream out;
    private Map<String, UserAction> actions = new HashMap<>();

        MenuClient(DataInputStream in, DataOutputStream out) {
            this.in = in;
            this.out = out;
        }

        void fillAction() {
            actions.put("cd", new ChangeDir());
            actions.put("dir", new ShowDir());
            actions.put("help", new Help());
            actions.put("download", new Download());
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

    private class ChangeDir implements UserAction {
        // execute - return message if console command "cd" used incorrectly
        public void execute(Command command) throws IOException {
            boolean changeTrue = in.readBoolean();
            if (!changeTrue) {
                System.out.println(" Message: Directory not found");
            }
        }
    }

        private class ShowDir implements UserAction {

            // showDir - return all folders and files that are in folder
            public void execute(Command command) throws IOException {
                int listFile = in.readInt();
                if (listFile != 0) {
                    for (int index = 0; index < listFile; index++) {
                        System.out.println(in.readUTF());
                    }
                } else {
                    System.out.println("Folder do not have any think..");
                }
                System.out.println();
            }
        }

        private class Help implements UserAction {
            // execute -
            public void execute(Command command) throws IOException {
                int size = in.readInt();
                for (int index = 0; index < size; index++) {
                    System.out.println(in.readUTF());
                }
                System.out.println();
            }
        }

    private class Download implements UserAction {
        public void execute(Command command) throws IOException {
            if (in.readBoolean()) {
                int quantity = in.readInt();
                int fileLength = in.readInt();
                File newFile = new File(command.getName());
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile))) {
                    int size = 0;
                    for (int index = 0; index < quantity; index++) {
                        size = size + SIZE;
                        if (size > fileLength) {
                            size = SIZE - (size - fileLength);
                            byte[] buffer = new byte[size];
                            in.read(buffer, 0, buffer.length);
                            bos.write(buffer, 0, buffer.length);
                            bos.flush();
                        } else {
                            byte[] buffer = new byte[SIZE];
                            in.read(buffer, 0, buffer.length);
                            bos.write(buffer, 0, buffer.length);
                            bos.flush();
                        }
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println(" File not found ... ");
            }
        }
    }

}



