package com.adidyk;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import static com.adidyk.Constant.*;

public class MenuServer {

    private DataInputStream in;
    private DataOutputStream out;
    private StringBuffer way;
    private Map<String, UserAction> actions = new HashMap<>();

    // Constructor
    public MenuServer(DataInputStream in, DataOutputStream out, StringBuffer root) {
        this.in = in;
        this.out = out;
        this.way = root;
    }

    // fillAction - fill actions
    public void fillAction() {
        actions.put("cd", new ChangerDir());
        actions.put("dir", new ShowDir());
        actions.put("help", new Help());
        actions.put("download", new Download());
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
                        System.out.println("Dir is found");
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
        // showDir - return all folders and files that are in directory
        public void execute(Command command) throws IOException {
            File file = new File(String.valueOf(way));
            File[] listFile  = file.listFiles();
            if (listFile != null) {
                out.writeInt(listFile.length);
                for (File list : listFile) {
                    if (list.isDirectory()) {
                        out.writeUTF(String.format("%s%10s%s%s", " <DIR>", list.length() / 1024, " [KiB]     ", list.getName()));
                    } else {
                        out.writeUTF(String.format("%s%10s%s%s", "      ", list.length() / 1024, " [KiB]     ", list.getName()));
                    }
                }
            }
          //  float arg = (float) 2000 / 1000;
          //  int result = (int)Math.ceil(arg);
          //  System.out.println("arg: " + arg);
          //  System.out.println("result: " + result);
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]", "           - show all folders and files that are in directory");
        }
    }

    // Help - return help
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
            return String.format(" %s%s%s%s", "[", this.key(), "]", "          - return info about all console commands");
        }
    }

    private class Download implements UserAction {
        //
        public String key () {
            return "download";
        }
        // execute- return all folders and files that are in folder

        public void execute(Command command) throws IOException {

            String wayFile = String.valueOf(way);
            wayFile = wayFile.concat(SEPARATOR).concat(command.getName());
            File file = new File(wayFile);
            if (file.isFile() && file.canRead()) {
                long quantity = Math.round(file.length() / SIZE);
                out.writeLong(file.length());
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                    byte[] buffer = new byte[bis.available()];
                    bis.read(buffer, 0, buffer.length);
                    out.write(buffer, 0, buffer.length);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("File not found");
            }

            //float arg = (float) 2000 / 1000;
            //int result = (int)Math.ceil(arg);


        }

        //                        byte[] buffer = new byte[bis.available()];
        //                      bis.read(buffer, 0, buffer.length);
        //                      bos.write(buffer, 0, buffer.length);
        //                      bos.flush();

        // info -
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]", "      - return all folders and files that are in folder");
        }
    }


}





