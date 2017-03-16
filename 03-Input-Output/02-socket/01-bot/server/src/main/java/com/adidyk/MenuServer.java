package com.adidyk;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import static com.adidyk.Constant.*;

public class MenuServer {

    private DataInputStream in;
    private DataOutputStream out;
    private Settings setting;
    private Map<String, UserAction> actions = new HashMap<>();

    // Constructor
    public MenuServer(DataInputStream in, DataOutputStream out, Settings setting) {
        this.in = in;
        this.out = out;
        this.setting = setting;
    }

    // fillAction - fill actions
    public void fillAction() {
        actions.put("cd", new ChangerDir());
        actions.put("dir", new ShowDir());
        actions.put("download", new Download());
        actions.put("upload", new Upload());
        actions.put("show", new ShowRootClient());
        actions.put("quit", new Quit());
        actions.put("help", new Help());
    }

    // select - select to executing by console command
    public void select(Command command) throws IOException {
        if (this.actions.containsKey(command.getKey())) {
            this.actions.get(command.getKey()).execute(command);
        }
    }

    // getWay - return way
    public void getWay() throws IOException {
        this.out.writeUTF(String.valueOf(this.way));
    }

    // ChangeDir - change directory
    private class ChangerDir implements UserAction {
        // key - return "cd"
        public String key () {
            return "cd";
        }
        // execute - change directory: input one step, output one step, output to the "ROOT" directory
        public void execute(Command command) throws IOException {
            boolean changeTrue = false;
            String directory = command.getName();
            if (directory == null) {
                way = new StringBuffer(ROOT);
                changeTrue = true;
            } else if (FROM.equals(directory)) {
                if (ROOT.equals(String.valueOf(way))) {
                    way = new StringBuffer(ROOT);
                    changeTrue = true;
                } else {
                    way = new StringBuffer(new File(String.valueOf(way)).getParent());
                    changeTrue = true;
                }
            } else {
                File files = new File(String.valueOf(way));
                for (File file : files.listFiles()) {
                    if (file.isDirectory() && file.getName().equals(directory)) {
                        way = way.append(SEPARATOR).append(file.getName());
                        changeTrue = true;
                        break;
                    }
                }
            }
            out.writeBoolean(changeTrue);
        }
        // info - return info about console commands for method execute
        public String info() {
            return String.format(" %s%s%s%s%n %s%s%s%s%n %s%s%s%s ",
                    "[", this.key(), " directory]", "  - input to directory by one step",
                    "[", this.key(), " ..]", "         - output from directory by one step",
                    "[", this.key(), "]", "            - output to the root directory");
        }
    }

    // ShowDir - show content of a directory
    private class ShowDir implements UserAction {
        // key - return "dir"
        public String key () {
            return "dir";
        }
        // execute - return all folders and files that are in directory
        public void execute(Command command) throws IOException {
            File file = new File(String.valueOf(way));
            File[] listFile  = file.listFiles();
            if (listFile != null) {
                out.writeInt(listFile.length);
                for (File list : listFile) {
                    if (list.isDirectory()) {
                        out.writeUTF(String.format("%s%11s%s%s", " <DIR>", list.length(), " [B]     ", list.getName()));
                    } else {
                        out.writeUTF(String.format("%s%11s%s%s", "      ", list.length(), " [B]     ", list.getName()));
                    }
                }
            }
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]",
                    "           - show all folders and files that are in directory");
        }
    }

    // Download - download selected files from the server to client root directory
    private class Download implements UserAction {
        // key - return "download"
        public String key () {
            return "download";
        }
        // execute - download selected file from the server to client root directory
        public void execute(Command command) throws IOException {
            String wayFile = String.valueOf(way);
            wayFile = wayFile.concat(SEPARATOR).concat(command.getName());
            File file = new File(wayFile);
            if (file.isFile() && file.canRead()) {
                out.writeBoolean(true);
                int quantity = (int)Math.floor((float)file.length() / SIZE);
                out.writeInt(quantity);
                out.writeInt((int)file.length());
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                    for (int index = 0; index < quantity; index++) {
                        byte[] buffer = new byte[SIZE];
                        bis.read(buffer, 0, buffer.length);
                        out.write(buffer, 0, buffer.length);
                        out.flush();
                    }
                    if (quantity * SIZE < (int)file.length()) {
                        byte[] buffer = new byte[(int)file.length() - quantity * SIZE];
                        bis.read(buffer, 0, buffer.length);
                        out.write(buffer, 0, buffer.length);
                        out.flush();

                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                out.writeBoolean(false);
            }
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s%n%s", "[", this.key(), " file]",
                    " - download selected file from the server to client",
                    "                   root directory");
        }
    }

    // Upload - upload selected file from the root directory client to current directory server
    private class Upload implements UserAction {
        // key - return "upload"
        public String key() {
            return "upload";
        }
        // execute - upload selected file from the root directory client to current directory server
        public void execute(Command command) throws IOException {
            if (in.readBoolean()) {
                int quantity = in.readInt();
                int fileLength = in.readInt();
                String wayFile = String.valueOf(way);
                wayFile = wayFile.concat(SEPARATOR).concat(command.getName());
                File newFile = new File(wayFile);
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile))) {
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
            } else {
                System.out.println(" File not found ... ");
            }
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s%n%s", "[", this.key(), " file]",
                    "   - upload selected file from the root directory client",
                    "                   to current directory server");
        }
    }

    // ShowRootClient - show content of a directory root client
    private  class ShowRootClient implements UserAction {
        // key - return "show"
        public String key() {
            return "show";
        }
        // execute - do not doing anything
        public void execute(Command command) throws IOException {
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]",
                    "          - show all files that are in directory root client");
        }
    }

    // ShowRootClient - disconnect from the server
    private  class Quit implements UserAction {
        // key - return "quit"
        public String key() {
            return "quit";
        }
        // execute - do not doing anything
        public void execute(Command command) throws IOException {
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]",
                    "          - disconnect from the server");
        }
    }

    // Help - return info about all console commands
    private class Help implements UserAction {
        // key - return "help"
        public String key() {
            return "help";
        }
        // execute - return info about all console commands
        public void execute(Command command) throws IOException {
            out.writeInt(actions.size());
            for (Map.Entry<String, UserAction> action : actions.entrySet()) {
                String string = action.getValue().info();
                out.writeUTF(string);
            }
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]",
                    "          - return info about all console commands");
        }
    }

}