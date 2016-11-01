package com.adidyk.start;

import com.adidyk.models.Comment;
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
        this.actions[1] = new ShowAllItem();
//        System.out.println(this.actions[0]);
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.track);
    }

    public void show() {
        System.out.println(" ------------------------------Tracker Menu --------------------------------");
        for (UserAction action: this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker track) {
            String name = input.ask(" Input name item: ");
            String desc = input.ask(" Input desc item: ");
            track.addItem(new Item(name, desc,  new Date().getTime()));
        }

        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Add new item.");
        }

    }

    private class ShowAllItem implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker track) {
            for (Item item : track.getAllItem()) {
                if (item != null) {
                    System.out.println(item.toString());
                    for (Comment comm : item.getAllComment()) {
                        if (comm != null) {
                            System.out.println("- [comm]: " +comm.getComment());
                        }
                    }
                }
            }
        }

        public String info() {
            return String.format(" %s%s%s", this.key(), ".", " Show all item.");
        }


    }




}
