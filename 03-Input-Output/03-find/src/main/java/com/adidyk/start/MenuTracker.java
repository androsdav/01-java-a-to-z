package com.adidyk.start;

import com.adidyk.modeles.Command;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static com.adidyk.modeles.Constant.SEPARATOR;

class MenuTracker {

    private Tracker tracker;
    private Map<String, UserAction> actions = new HashMap<>();

    // Constructor
    MenuTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    // fillAction - fills actions
    void fillAction() {
        actions.put("cd", new SetPath());
        actions.put("find", new Find());
        actions.put("show", new Show());
        actions.put("save", new Save());
        actions.put("quit", new Quit());
        actions.put("help", new Help());
    }

    // select - selects execution from the console command
    void select(Command command) throws IOException {
        if (this.actions.containsKey(command.getKey())) {
            this.actions.get(command.getKey()).execute(command, this.tracker);
        } else {
            System.out.println(" [Info]: command not found  ...");
        }
    }

    // SetPath - sets path or folder name - root
    private class SetPath implements UserAction {
        // key - return "cd"
        public String key() {
            return "cd";
        }
        // execute - sets path from the console or folder name - root
        public void execute(Command command, Tracker tracker) {
            tracker.setPath(command.getName());
        }
        // info - returns info about console command for execute method
        public String info() {
            return String.format(" %s%s%s%s%s%s%s%s%n %s%s%s%s%s",
                    "[", this.key(), " path", "]",
                    "          - sets path, for input use file separator ", "[", SEPARATOR, "]",
                    "[", this.key(), " root", "]",
                    "          - sets root folder");
        }
    }

    // Find - finds all files in folder and show to console
    private class Find implements UserAction {
        // key - return "find"
        public String key() {
            return "find";
        }
        // execute - finds all files in folder and show to console
        public void execute(Command command, Tracker tracker) {
            tracker.remove();
            Filter filter = new Filter(command.getName(), command.getKeyFind());
            ArrayList<String> result = tracker.find(tracker.getPath(), filter);
            if (result.size() != 0) {
                System.out.println();
                for (String item : result) {
                    System.out.println(" - " + item);
                }
            } else {
                System.out.print(" [Info]: nothing found ...\n");
            }
        }
        // info - returns info about console command for execute method
        public String info() {
            return String.format(" %s%s%s%s%s%n %s%s%s%s%s%n %s%s%s%s%s%n %s%s%s%s%s",
                    "[", this.key(), " name.txt -f", "]", " - searches all files by name and extension together",
                    "[", this.key(), " sub -m", "]", "      - searches all files by maximum match",
                    "[", this.key(), " txt -e", "]", "      - searches all files by extension",
                    "[", this.key(), " regex -r", "]", "    - searches all files by regex");
        }
    }

    // Show - shows last result searches
    private class Show implements UserAction {
        // key - return "show"
        public String key() {
            return "show";
        }
        // execute - shows last result searches
        public void execute(Command command, Tracker tracker) {
            ArrayList<String> result = tracker.getResult();
            if (result.size() != 0) {
                System.out.println();
                for (String item : result) {
                    System.out.println(" - " + item);
                }
            } else {
                System.out.print(" [Info]: nothing found ...\n");
            }
        }
        // info - return info about console command for execute method
        public String info() {
            return String.format(" %s%s%s%s",
                    "[", this.key(), "]", "             - shows last result searches");
        }
    }

    // Save - save result to file log.txt
    private class Save implements UserAction {
        // key - return "save"
        public String key() {
            return "save";
        }
        // execute -
        public void execute(Command command, Tracker tracker) {
            tracker.save(command.getName());
        }
        // info - return info about console command for execute method
        public String info() {
            return String.format(" %s%s%s%s",
                    "[", this.key(), "]", "             - shows last result searches");
        }
    }

    // Quit - program end work
    private class Quit implements UserAction {
        // key - return "quit"
        public String key() {
            return "quit";
        }
        // execute - don`t doing anything
        public void execute(Command command, Tracker tracker) {
        }
        // info - return info about console command for execute method
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]",
                    "             - program end work");
        }
    }

    // Help - return info about all console commands
    private class Help implements UserAction {
        // key - return "help"
        public String key() {
            return "help";
        }
        // execute - return info about all console commands
        public void execute(Command command, Tracker tracker) throws IOException {
            System.out.println();
            for (Map.Entry<String, UserAction> action : actions.entrySet()) {
                String string = action.getValue().info();
                System.out.println(string);
            }
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]",
                    "             - return info about all console commands");
        }
    }

}
