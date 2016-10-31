package com.adidyk.start;

import com.adidyk.models.Item;

import java.util.Date;

public class MenuTracker {

    private Input input;
    private Tracker track;
    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker track) {
        this.input = input;
        this.track = track;
    }

    public void init() {

    }

    private class addItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker track) {
            String name = input.ask(" Input name: ");
            String desc = input.ask(" Input desc: ");
            track.addItem(new Item(name, desc,  new Date().getTime()));
        }

        public String info() {
            return String.format("%s %s", this.key(), "add the new item");
        }

    }


}
