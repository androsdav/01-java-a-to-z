package com.adidyk.start;

import com.adidyk.models.Item;

import java.util.Date;

import static java.lang.Integer.valueOf;

public class StartUiTest {

    private Input input;
    private Tracker track;

    private StartUiTest(Input input) {
        this.input = input;
        this.track = new Tracker();
        this.track.addItem(new Item("task0", "desc0", new Date().getTime()));
        this.track.addItem(new Item("task1", "desc1", new Date().getTime()));
        this.track.addItem(new Item("task2", "desc2", new Date().getTime()));
        this.track.addItem(new Item("task3", "desc3", new Date().getTime()));
        this.track.getAllItem()[2].setId("8888");
        this.track.getAllItem()[3].setId("9999");
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
        Input input = new StubInput(new String[] {
                "1",                                // 1. Show all item.               (ShowAllItem)
                "2", "task0", "desc2", "1",         // 2. Add new item.                (AddItem and ShowAllItem)
                "3", "9999",                        // 3. Search item by id.           (SearchItemById and ShowAllItem)
                "4", "task0",                       // 4. Search item by name.         (SearchItemByName)
                "5", "desc2",                       // 5. Search item by description.  (SearchItemByDescription)
                "6", "8888", "1",                   // 6. Remove item by id.           (RemoveItemById and ShowAllItem)
                "7", "9999", "task6", "desc6", "1", // 7. Update item by id.           (UpdateItemById and ShowAllItem)
                "8", "9999", "comm1", "1",          // 8. Add comment by id.           (AddCommentById and ShowAllItem)
                "9"});                              // 9. Exit.
        new StartUiTest(input).init();
    }

}

