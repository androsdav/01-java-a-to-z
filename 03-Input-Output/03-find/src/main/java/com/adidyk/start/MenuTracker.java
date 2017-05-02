package com.adidyk.start;

import com.adidyk.start.Filter;
import com.adidyk.modeles.Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private Map<String, UserAction> actions = new HashMap<>();
    public static final String SEPARATOR = System.getProperty("file.separator");

    // Constructor
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    // fillAction - fills actions
    public void fillAction() {
        actions.put("cd", new SetPath());
        actions.put("find", new Find());
        actions.put("help", new Help());
        actions.put("quit", new Quit());
        actions.put("show", new Show());
    }

    // select - selects execution from the console command
    public void select(Command command) throws IOException {
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
        // execute - sets path from the console
        public void execute(Command command, Tracker tracker) {
            tracker.setPath(command.getName());
        }
        // info - returns info about console command for execute method
        public String info() {
            return String.format(" %s%s%s%s%s%s%s%s%n %s%s%s%s%s",
                    "[", this.key(), " path", "]", "    - sets path, for input use file separator ", "[", SEPARATOR, "]",
                    "[", this.key(), " root", "]", "    - sets root folder");
        }
    }

    // Find -
    private class Find implements UserAction {
        // key -
        public String key() {
            return "find";
        }
        // execute -
        public void execute(Command command, Tracker tracker) {
            tracker.remove();
            Filter filter = new Filter(command.getName(), command.getKeyFind());
            //ArrayList<String> result = tracker.find(tracker.getPath(), filter);
            ArrayList<String> result = tracker.find(tracker.getPath(), filter);
            for (String item : result) {
                System.out.println("Result find: " + item);
            }
        }
        // info -
        public String info() {
            return String.format(" %s", "finding file");
        }
    }

    // Show -
    private class Show implements UserAction {
        // key -
        public String key() {
            return "show";
        }
        // execute -
        public void execute(Command command, Tracker tracker) {
            ArrayList<String> result = tracker.getResult();
            for (String item : result) {
                System.out.println("Result find: " + item);
            }
        }
        // info -
        public String info() {
            return String.format("%s", this.key());
        }
    }

    private class Quit implements UserAction {
        // key - return "quit"
        public String key() {
            return "quit";
        }
        // execute - do not doing anything
        public void execute(Command command, Tracker tracker) {
        }
        // info -
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]",
                    "    - end work with program");
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
            for (Map.Entry<String, UserAction> action : actions.entrySet()) {
                String string = action.getValue().info();
                System.out.println(string);
            }
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]",
                    "          - return info about all console commands");
        }
    }

}
