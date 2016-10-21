package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import java.util.Date;

public class StartUi {

    private Input input;
    private Tracker track;
    private boolean flagExit;

    private StartUi(Input input) {
        this.input = input;
        this.track = new Tracker();
        this.flagExit = true;
    }

    // init - initialization and start method workItem
    private void init() {
        descriptionItem();
        addItemDefault();
        workItem();
    }

    // main - just main :)
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUi(input).init();
    }

    // description - static description for program Tracker
    private void descriptionItem() {
        System.out.println();
        System.out.println(" ---------------------------------------------------------------------------");
        System.out.println("                          << Tracker ver. 1.0 >> ");
        System.out.println("                     it provides to work with program ");
        System.out.println("                         for accounting of statement");
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // addItemDefault - add item in item[] dy default
    private void addItemDefault() {
        this.track.addItem(new Item("task0", "desc0", new Date().getTime()));
        this.track.addItem(new Item("task1", "desc1", new Date().getTime()));
        this.track.addItem(new Item("task2", "desc2", new Date().getTime()));
        this.track.addItem(new Item("task3", "desc3", new Date().getTime()));
    }

    // workItem - work item
    private void workItem() {
        while (this.flagExit) {
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
        if (this.flagExit) {
            String key = this.input.ask(" Choose key: ");
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
                    this.flagExit = false;
                    break;
                default:
                    System.out.println(" Isn`t a valid symbol. Repeat please again.");
                    break;
            }
        }
    }

    // showAllItem - show all item, key = " 1 "
    private void showAllItem() {
        Item[] result = this.track.getAllItem();
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
        String name = this.input.ask(" Input name item: ");
        String description = this.input.ask(" Input name description: ");
        long create = new Date().getTime();
        this.track.addItem(new Item(name, description, create));
    }

    // searchItemById - search item by id, key = " 3 "
    private void searchItemById() {
        String id = this.input.ask(" Input id: ");
        Item item = this.track.searchItemById(id);
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
        String name = this.input.ask(" Input name: ");
        Item[] result = this.track.getAllItem();
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
        String desc = this.input.ask(" Input description: ");
        Item[] result = this.track.getAllItem();
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
        String id = this.input.ask(" Input id: ");
        this.track.removeItemById(id);
    }

    // updateItemById - update item by id, key = " 7 "
    private void updateItemById() {
        String id = this.input.ask(" Input id: ");
        String name = this.input.ask(" Input new name item: ");
        String description = this.input.ask(" Input new description: ");
        long create = new Date().getTime();
        Item item = new Item(name, description, create);
        item.setId(id);
        Item result = this.track.searchItemById(id);
        this.track.updateItemById(item);
        Comment[] comment = result.getAllComment();
        for (Comment comm : comment) {
            if (comm != null) {
                this.track.addCommentById(id, comm);
            }
        }
    }

    // addCommentById - add comment by id, key = " 8 "
    private void addCommentById() {
        String id = this.input.ask(" Input id: ");
        Comment comment = new Comment(this.input.ask(" Input comment: "));
        this.track.addCommentById(id, comment);
    }

}



