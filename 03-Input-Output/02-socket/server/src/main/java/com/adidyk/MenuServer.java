package com.adidyk;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import static com.adidyk.Constant.*;

public class MenuServer {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private StringBuffer way;
    private Map<String, UserAction> actions = new HashMap<>();

    public MenuServer(Socket socket, DataInputStream in, DataOutputStream out, StringBuffer root) {
        this.socket = socket;
        this.in = in;
        this.out = out;
        this.way = root;
    }

    public void fillAction() {
        actions.put("cd", new ChangerDir());
        actions.put("dir", new ShowDir());
        actions.put("help", new Help());
        actions.put("download", new Download());
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
            out.writeInt(actions.size());
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
                out.writeLong(file.length());
     //           DataOutputStream outTemp = out;
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)) {
                    try (BufferedOutputStream bos = new BufferedInputStream((socket.getOutputStream()))) {

                        byte[] buffer = new byte[bis.available()];
                        bos.write(buffer,0,buffer.length);

                        int

                        //   String row;
                        //   while ((row = br.readLine()) != null) {
                        //       outTemp.writeUTF(row);
                        //       System.out.println(row);

                        //out.close();
                    }
                }
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                //FileReader fr = new FileReader(file);
                //BufferedReader br = new BufferedReader(new FileReader(file));
            }


            //File file = new File(String.valueOf(way));

        }
        // info -
        public String info() {
            return String.format(" %s%s%s%s",
                    "[", this.key(), "]", "        - return all folders and files that are in folder");
        }
    }

}





