package com.adidyk;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import static com.adidyk.Constant.*;

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
        actions.put("show", new ShowRootClient());
        actions.put("quit", new Quit());
        actions.put("help", new Help());
    }

    // select - select to executing by console command
    void select(Command command) throws IOException {
        if (actions.containsKey(command.getKey())) {
            this.actions.get(command.getKey()).execute(command);
        } else {
            System.out.println(" [Info]: command not found ...");
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
                System.out.println(" [Info]: directory not found ...");
            }
        }
    }

    // ShowDir - show content of a directory by server
    private class ShowDir implements UserAction {
        // execute - show content of a directory by server
        public void execute(Command command) throws IOException {
            int listFile = in.readInt();
            if (listFile != 0) {
                System.out.println();
                for (int index = 0; index < listFile; index++) {
                    System.out.println(in.readUTF());
                }
            } else {
                System.out.println(" [Info]: directory do not have anything ...");
            }
        }
    }

    // Download - download selected files from the server to client root directory
    private class Download implements UserAction {
        // execute - download selected files from the server to client root directory
        public void execute(Command command) throws IOException {
            if (in.readBoolean()) {
                int quantity = in.readInt();
                int fileLength = in.readInt();
                File newFile = new File(ROOT.concat(SEPARATOR).concat(command.getName()));
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile))) {
                    System.out.println(" [Info]: file is downloaded, wait ...");
                    for (int index = 0; index < quantity; index++) {
                        byte[] buffer = new byte[SIZE];
                        in.read(buffer, 0, buffer.length);
                        bos.write(buffer, 0, buffer.length);
                        bos.flush();
                    }
                    if (quantity * SIZE < fileLength) {
                        byte[] buffer = new byte[fileLength - quantity * SIZE];
                        in.read(buffer, 0, buffer.length);
                        bos.write(buffer, 0, buffer.length);
                        bos.flush();
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println(" [Info]: download is complete ...");
            } else {
                System.out.println(" [Info]: file not found ... ");
            }
        }
    }

    // Upload - upload selected file from the root directory client to current directory server
    private class Upload implements UserAction {
        // execute - upload selected file from the root directory client to current directory server
        public void execute(Command command) throws IOException {
            String wayFile = ROOT;
            wayFile = wayFile.concat(SEPARATOR).concat(command.getName());
            File file = new File(wayFile);
            if (file.isFile() && file.canRead()) {
                out.writeBoolean(true);
                int quantity = (int)Math.floor((float)file.length() / SIZE);
                out.writeInt(quantity);
                out.writeInt((int)file.length());
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                    System.out.println(" [Info]: file is uploaded, wait ...");
                    for (int index = 0; index < quantity; index++) {
                        byte[] buffer = new byte[SIZE];
                        bis.read(buffer, 0, buffer.length);
                        out.write(buffer, 0, buffer.length);
                        out.flush();
                    }
                    if (quantity * SIZE < file.length()) {
                        byte[] buffer = new byte[(int)file.length() - quantity * SIZE];
                        bis.read(buffer, 0, buffer.length);
                        out.write(buffer, 0, buffer.length);
                        out.flush();
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println(" [Info]: upload is complete ...");
            } else {
                out.writeBoolean(false);
                System.out.println( " [Info]: file not found ...");
            }
        }
    }

    // ShowRootClient - show content of a directory root client
    private class ShowRootClient implements UserAction {
        // execute - return all folders and files that are in directory root client
        public void execute(Command command) throws IOException {
            System.out.println(" Client: root>");
            String way = ROOT;
            File file = new File(way);
            File[] listFile = file.listFiles();
            if (listFile.length != 0) {
                System.out.println();
                for (File list : listFile) {
                    if (list.isDirectory()) {
                        System.out.println(String.format("%s%11s%s%s", " <DIR>", list.length(), " [B]     ", list.getName()));
                    } else {
                        System.out.println(String.format("%s%11s%s%s", "      ", list.length(), " [B]     ", list.getName()));
                    }
                }
            } else {
                System.out.println(" [Info]: directory do not have anything ...");
            }
        }
    }

    // Quit - disconnect from the server
    private class Quit implements UserAction {
        // execute - do not doing anything
        public void execute(Command command) throws IOException {
            }
        }

    // Help - return info about all console commands
    private class Help implements UserAction {
        // execute - return info about all console commands
        public void execute(Command command) throws IOException {
            System.out.println();
            int size = in.readInt();
            for (int index = 0; index < size; index++) {
                System.out.println(in.readUTF());
            }
        }
    }

}



