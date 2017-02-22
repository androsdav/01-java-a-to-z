package com.adidyk;

import java.io.*;
import java.net.Socket;
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

        // showDir - return all folders and files that are in folder
        public void execute(Command command) throws IOException {
            boolean dirFound = in.readBoolean();
            if (!dirFound) {
                System.out.println(" Directory not found");
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

            public void execute(Command command) throws IOException {
                int test = in.readInt();
                for (int index = 0; index < test; index++) {
                    String string = in.readUTF();
                    System.out.println(string);
                }
                System.out.println();
            }
        }

    private class Download implements UserAction {
        public void execute(Command command) throws IOException {
            long fileLength= in.readLong();
   //         if (fileLength != 0) {
                File newFile = new File(command.getName());
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile))) {
                    byte[] buffer = new byte[(int) fileLength];
                    in.read(buffer, 0, buffer.length);
                    bos.write(buffer, 0, buffer.length);
        //            int c;
         //           while ((c = in.read()) != -1) {
         //               bos.write(c);
          //          }
                }
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
     //       }
        }
    }

}



