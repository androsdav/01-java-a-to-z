package com.adidyk;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.adidyk.Constant.*;

public class MenuServer {

    private DataOutputStream out;
    private StringBuffer way;
    private Map<String, UserAction> actions = new HashMap<>();

    public MenuServer(DataOutputStream out, StringBuffer root) {
        this.out = out;
        this.way = root;
    }

    public void fillAction() {
        actions.put("cd", new ChangerDir());
        actions.put("dir", new ShowDir());
        actions.put("help", new Help());
    }

    public void select(Command command) throws IOException {
        if (this.actions.containsKey(command.getKey())) {
            this.actions.get(command.getKey()).execute(command);
        }
    }

    public void getWay() throws IOException {
        this.out.writeUTF(String.valueOf(this.way));
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
                if (ROOT.equals(String.valueOf(way))) {
                    way = new StringBuffer(ROOT);
                } else {
                    way = new StringBuffer(new File(String.valueOf(way)).getParent());
                }
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
        }
        // info - return info about method execute
        public String info() {
            return String.format(" %s%s%s%s%n %s%s%s%s%n %s%s%s%s ",
                    "[", this.key(), " folder]", "  - change folder",
                    "[", this.key(), " ..]", "      - change folder",
                    "[", this.key(), "]", "         - change folder");
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
            if (listDir != null) {
                out.writeInt(listDir.length);
                for (String list : listDir) {
                    out.writeUTF(list);
                }
            }
        }
        // info -
        public String info() {
            return String.format(" %s%s%s%s",
                    "[", this.key(), "]", "        - return all folders and files that are in folder");
        }
    }

    private class Help implements UserAction {
        //
        public String key() {
            return "help";
        }
        //
        public void execute(Command command) throws IOException {
            for (Map.Entry<String, UserAction> action : actions.entrySet()  ) {
                String string = action.getValue().info();
                out.writeUTF(string);
            }
        }
        //
        public String info() {
            return String.format(" %s%s%s%s",
                                 "[", this.key(), "]", "       - help");
        }
    }

}





