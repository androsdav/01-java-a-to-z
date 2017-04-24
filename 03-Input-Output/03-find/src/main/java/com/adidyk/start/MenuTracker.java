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
}
