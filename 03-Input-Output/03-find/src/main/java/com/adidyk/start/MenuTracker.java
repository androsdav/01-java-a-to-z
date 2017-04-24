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
    }

    public void select(Command command) throws IOException {
        if (this.actions.containsKey(command.getKey())) {
            this.actions.get(command.getKey()).execute(command, this.tracker);
        }
    }

    private class SetPath implements UserAction {

        public String key() {
            return "input";
        }

        public void execute(Command command, Tracker tracker) {

        }

        public String info() {
            return String.format("%s", "test");
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
//            out.writeInt(actions.size());
            for (Map.Entry<String, UserAction> action : actions.entrySet()) {
                String string = action.getValue().info();
                System.out.println()out.writeUTF(string);
            }
        }
        // info - return info about console command for method execute
        public String info() {
            return String.format(" %s%s%s%s", "[", this.key(), "]",
                    "          - return info about all console commands");
        }
    }
}
