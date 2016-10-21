package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import java.util.Date;

public class StartUiTest{

    private Input input;
    private Tracker track;
    private boolean flagExit;

    private StartUiTest(Input input) {
        this.input = input;
        this.track = new Tracker();
        this.flagExit = true;
    }

    private void init() {
        descriptionTracker();
        addItemDefault();
        workItem();
    }

    public static void main(String[] args) {
        Input input = new StubInput(new String[] {
                "1",                                // 1. Show all item.               (showAllItem)
                "2", "task0", "desc2", "1",         // 2. Add new item.                (addItem and showAllItem)
                "3", "9999",                        // 3. Search item by id.           (searchItemById and showAllItem)
                "4", "task0",                       // 4. Search item by name.         (searchItemByName)
                "5", "desc2",                       // 5. Search item by description.  (searchItemByDescription)
                "6", "8888", "1",                   // 6. Remove item by id.           (removeItemById and showAllItem)
                "7", "9999", "task6", "desc6", "1", // 7. Update item by id.           (updateItemById and showAllItem)
                "8", "9999", "comm1", "1",          // 8. Add comment by id.           (addCommentById and showAllItem)
                "9"});                              // 9. Exit.
        new StartUiTest(input).init();
    }

    // description - static description for program Tracker
    private void descriptionTracker() {
        System.out.println();
        System.out.println(" ---------------------------------------------------------------------------");
        System.out.println("                          << Tracker ver. 1.0 >> ");
        System.out.println("                     it provides to work with program ");
        System.out.println("                         for accounting of statement");
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // addItemDefault - add item in item[] by default and set id default
    private void addItemDefault() {
        this.track.addItem(new Item("task0", "desc0", new Date().getTime()));
        this.track.addItem(new Item("task1", "desc1", new Date().getTime()));
        this.track.addItem(new Item("task2", "desc2", new Date().getTime()));
        this.track.addItem(new Item("task3", "desc3", new Date().getTime()));
        this.track.getAllItem()[2].setId("8888");
        this.track.getAllItem()[3].setId("9999");
    }

    private void workItem() {
        while(this.flagExit) {
            showMenu();
            keyMenu();
        }
    }

    // showMenu - show all menu item
    private void showMenu() {
        System.out.println("");
        System.out.println(" ------------------------------Tracker Menu --------------------------------");
        System.out.println(" 1. Show all item.");
        System.out.println(" 2. Add new item.");
        System.out.println(" 3. Search item by id.");
        System.out.println(" 4. Search item by name.");
        System.out.println(" 5. Search item by description.");
        System.out.println(" 6. Remove item by id.");
        System.out.println(" 7. Update item by id.");
        System.out.println(" 8. Add comment by id.");
        System.out.println(" 9. Exit.");
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // keyMenu - select action menu item
    private void keyMenu() {
        if (flagExit) {
            String key = input.ask(" Choose key: ");
            switch (key) {
                case "1":
                    showAllItem();
                    break;
                case "2":
                    addItem();
                    break;
               case "3":
                    searchItemById();
                    break;
                case "4":
                    searchItemByName();
                    break;
                case "5":
                    searchItemByDescription();
                    break;
                case "6":
                    removeItemById();
                    break;
                case "7":
                    updateItemById();
                    break;
                case "8":
                    addCommentById();
                    break;
                case "9":
                    flagExit = false;
                    break;
                default:
                    System.out.println(" Isn`t a valid symbol. Repeat please again.");
                    break;
            }
        }
    }

    // showAllItem - show all item, key = " 1 "
    private void showAllItem() {
        Item[] result = track.getAllItem();
        for (Item item : result) {
            if (item != null) {
                System.out.println(item.toString());
                for (Comment comm : item.getAllComment()) {
                    if (comm != null) {
                        System.out.println("   - [comm]: " + comm.getComment());
                    }
                }
            }
        }
    }

    // addItem - add new item, key = " 2 "
    private void addItem() {
        String name = input.ask(" Input name item: ");
        String description = input.ask(" Input name description: ");
        long create = new Date().getTime();
        track.addItem(new Item(name, description, create));
    }

    // searchItemById - search item by id, key = " 3 "
    private void searchItemById() {
        String id = input.ask(" Input id: ");
        //this.track.getAllItem()[3].setId(id); // new line
        Item item = track.searchItemById(id);
        if (item != null) {
            System.out.println(item.toString());
            for (Comment comm : item.getAllComment()) {
                if (comm != null) {
                    System.out.println("   - [comm]: " + comm.getComment());
                }
            }
        } else {
            System.out.println(" No result by id");
        }
    }

    // searchItemByName - find item by name, key = " 4 "
    private void searchItemByName() {
        String name = input.ask(" Input name: ");
        Item[] result = track.getAllItem();
        for (Item item : result) {
            if (item != null && item.getName().equals(name)) {
                System.out.println(item.toString());
                for (Comment comm : item.getAllComment()) {
                    if (comm != null) {
                        System.out.println("   - [comm]: " + comm.getComment());
                    }
                }
            }
        }
    }

    // searchItemByDescription - find item by sub description, key = " 5 "
    private void searchItemByDescription() {
        String desc = input.ask(" Input description: ");
        Item[] result = track.getAllItem();
        for (Item item : result) {
            if (item != null && item.getDescription().contains(desc)) {
                System.out.println(item.toString());
                for (Comment comm : item.getAllComment()) {
                    if (comm != null) {
                        System.out.println("   - [comm]: " + comm.getComment());
                    }

                }
            }
        }
    }

    // deleteItemById - delete item by id, key = " 6 "
    private void removeItemById() {
        String id = input.ask(" Input id: ");
        track.removeItemById(id);
    }

    // updateItemById - update item by id, key = " 7 "
    private void updateItemById() {
        String id = input.ask(" Input id: ");
        String name = input.ask(" Input new name item: ");
        String description = input.ask(" Input new description: ");
        long create = new Date().getTime();
        Item item = new Item(name, description, create);
        item.setId(id);
        Item result = track.searchItemById(id);
        track.updateItemById(item);
        Comment[] comment = result.getAllComment();
        for (Comment comm : comment) {
            if (comm != null) {
                track.addCommentById(id, comm);
            }
        }
    }

    // addCommentById - add comment by id, key = " 8 "
    private void addCommentById() {
        String id = input.ask(" Input id: ");
        Comment comment = new Comment(input.ask(" Input comment: "));
        track.addCommentById(id, comment);
    }

}
