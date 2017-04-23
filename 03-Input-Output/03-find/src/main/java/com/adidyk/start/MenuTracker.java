package com.adidyk.start;

import com.adidyk.UserAction;

import java.util.HashMap;
import java.util.Map;

public class MenuTracker {

    private Map<String, UserAction> actions = new HashMap<>();

    public void fillAction() {
        actions.put("input", new SetPath());
    }

    private class SetPath implements UserAction {

        public String key() {
            return "input";
        }

        public void execute() {

        }
    }
}
