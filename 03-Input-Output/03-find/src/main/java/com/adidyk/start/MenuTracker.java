package com.adidyk.start;

import com.adidyk.modeles.Command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private Map<String, UserAction> actions = new HashMap<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction() {
        actions.put("input", new SetPath());
        actions.put("help", new Help());
    }

    public void select(Command command) throws IOException {
        if (this.actions.containsKey(command.getKey())) {
            this.actions.get(command.getKey()).execute(command, this.tracker);
        } else {
            System.out.println(" [Info]: command not found  ...");
        }
    }

    // SetPath -
    private class SetPath implements UserAction {
        // key -
        public String key() {
            return "input";
        }
        // execute -
        public void execute(Command command, Tracker tracker) {
            tracker.setPath(command.getName());
        }
        // info -
        public String info() {
            return String.format(" %s%s%s%s%s", "[", this.key(), " path", "]",
                    "    - input path");
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
