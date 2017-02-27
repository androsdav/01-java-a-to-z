package com.adidyk;

import javafx.scene.control.Separator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static com.adidyk.Constant.ROOT;
import static com.adidyk.Constant.SEPARATOR;
import static com.adidyk.Constant.SIZE;

public class MenuClient {
    private DataInputStream in;
    private DataOutputStream out;
    private Map<String, UserAction> actions = new HashMap<>();

    // Constructor
    MenuClient(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    // fillAction - fill actions
    void fillAction() {
        actions.put("cd", new ChangeDir());
        actions.put("dir", new ShowDir());
        actions.put("download", new Download());
        actions.put("upload", new Upload());
        actions.put("help", new Help());
    }

    // select - select to executing by console command
    void select(Command command) throws IOException {
        if (actions.containsKey(command.getKey())) {
            this.actions.get(command.getKey()).execute(command);
        } else {
            System.out.println("\n [Info]: command not found ...");
        }
    }

    // getWay - return way from server
    public void getway() throws IOException {
        String string = this.in.readUTF();
        System.out.print("\n Server: " +string + "> ");
    }

    // ChangeDir - change directory by server
    private class ChangeDir implements UserAction {
        // execute - return message if console command "cd" used incorrectly
        public void execute(Command command) throws IOException {
            boolean changeTrue = in.readBoolean();
            if (!changeTrue) {
                System.out.println("\n [Info]: directory not found ...");
            }
        }
    }

    // ShowDir - show content of a directory by server
    private class ShowDir implements UserAction {
        // showDir - show content of a directory by server
        public void execute(Command command) throws IOException {
            System.out.println();
            int listFile = in.readInt();
            if (listFile != 0) {
                for (int index = 0; index < listFile; index++) {
                    System.out.println(in.readUTF());
                }
            } else {
                System.out.println(" [Info]: directory do not have anythink ...");
            }
        }
    }

    // Download - download selected files from the server to client root directory
    private class Download implements UserAction {
        //
        public void execute(Command command) throws IOException {
            if (in.readBoolean()) {
                int quantity = in.readInt();
                int fileLength = in.readInt();
                File newFile = new File(ROOT.concat(SEPARATOR).concat(command.getName()));
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
                System.out.println("\n [Info]: file not found ... ");
            }
        }
    }

    // Upload -
    private class Upload implements UserAction {
        // execute -
        public void execute(Command command) throws IOException {
            String wayFile = ROOT;
            wayFile = wayFile.concat(SEPARATOR).concat(command.getName());
            File file = new File(wayFile);
            if (file.isFile() && file.canRead()) {
                out.writeBoolean(true);
                int quantity = (int)Math.ceil((float)file.length() / SIZE);
                out.writeInt(quantity);
                out.writeInt((int)file.length());
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                    int size = 0;
                    for (int index = 0; index < quantity; index++) {
                        size = size + SIZE;
                        if (size > file.length()) {
                            size = SIZE - (size - (int)file.length());
                            byte[] buffer = new byte[size];
                            bis.read(buffer, 0, buffer.length);
                            out.write(buffer, 0, buffer.length);
                            out.flush();
                        } else {
                            byte[] buffer = new byte[SIZE];
                            bis.read(buffer, 0, buffer.length);
                            out.write(buffer, 0, buffer.length);
                            out.flush();
                        }
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                out.writeBoolean(false);
                System.out.println( "\n [Info]: file not found ...");
            }
        }
    }

    // Help -
    private class Help implements UserAction {
        // execute -
        public void execute(Command command) throws IOException {
            System.out.println();
            int size = in.readInt();
            for (int index = 0; index < size; index++) {
                System.out.println(in.readUTF());
            }
        }
    }

}



