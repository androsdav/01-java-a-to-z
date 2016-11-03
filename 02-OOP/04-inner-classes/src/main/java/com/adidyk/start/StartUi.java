package com.adidyk.start;

import com.adidyk.models.Item;
import java.util.Date;
import static java.lang.Integer.valueOf;

public class StartUi {

    private Input input;
    private Tracker track;

    private StartUi(Input input) {
        this.input = input;
        this.track = new Tracker();
        this.track.addItem(new Item("task0", "desc0", new Date().getTime()));
        this.track.addItem(new Item("task1", "desc1", new Date().getTime()));
        this.track.addItem(new Item("task2", "desc2", new Date().getTime()));
        this.track.addItem(new Item("task3", "desc3", new Date().getTime()));
    }

    // init - initialization and start work
    private void init() {
        MenuTracker menu = new MenuTracker(this.input, this.track);
        menu.fillAction();
        while(true) {
            menu.show();
            int key = valueOf(input.ask(" Choose key: "));
            menu.select(key);
            if (key == 9) break;
        }
    }

    // main - just main :)
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUi(input).init();
    }

}
