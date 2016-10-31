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

    public void fillAction() {
        this.actions[0] = new AddItem();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.track);
    }

    public void show() {
        for (UserAction action: this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {

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
