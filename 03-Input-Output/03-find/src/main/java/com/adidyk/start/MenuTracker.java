package com.adidyk.start;

import com.adidyk.modeles.Command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuTracker {

    private Map<String, UserAction> actions = new HashMap<>();

    public void fillAction() {
        actions.put("input", new SetPath());
    }

    public void select(Command command) throws IOException {
        if (this.actions.containsKey(command.getKey())) {
            this.actions.get(command.getKey()).execute(command);
        }
    }

    private class SetPath implements UserAction {

        public String key() {
            return "input";
        }

        public void execute(Command command) {

        }

        public String info() {
            return String.format("%s", "test");
        }
    }
}
