package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import java.util.*;

public class StartUi {

    Tracker track = new Tracker();
    Date date = new Date();
    Scanner scanner = new Scanner(System.in);
    ConsoleInput input = new ConsoleInput();

    // Constructor
    public StartUi() {
      //  initialization();
        this.input.addItemDefault();
        this.input.workItem();
    }

    // Main
    public static void main(String[] arg) {
        StartUi start = new StartUi();
    }

    // initialization
   // public void initialization() {
//        this.track = new Tracker();
//        this.date = new Date();
//        this.scanner = new Scanner(System.in);
//        this.input = new ConsoleInput();
        //this.flagExit = true;

    //}

    // Testing method addItem
    private void addItemTest() {
        System.out.println();
        System.out.println(" 1) Testing method addItem:");
        System.out.println(" ---------------------------------------------------------------------------");
        this.track.addItem(new Item("task0", "desc0", this.date.getTime()));
        this.track.addItem(new Item("task1", "desc1", this.date.getTime()));
        this.track.addItem(new Item("task2", "desc2", this.date.getTime()));
        this.track.addItem(new Item("task3", "desc3", this.date.getTime()));
        this.track.addItem(new Item("task4", "desc4", this.date.getTime()));
        this.track.addItem(new Item("task5", "desc5", this.date.getTime()));
        Item[] result = this.track.getAllItem();
        for (Item item : result) {
            if (item != null) {
                System.out.println(item.toString(item));
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // Testing method searchItemById
    private void searchItemByIdTest() {
        System.out.println();
        System.out.println(" 2) Testing method searchItemById:");
        System.out.println(" ---------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id = items[1].getId();
        System.out.println(" -> Search by [id]: " +id);
        Item item = this.track.searchItemById(id);
        System.out.println(item.toString(item));
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // Testing method removeItemById
    private void removeItemByIdTest() {
        System.out.println();
        System.out.println(" 3) Testing method removeItemById:");
        System.out.println(" ---------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id = items[3].getId();
        System.out.println(" -> Remove by [id]: " +id);
        this.track.removeItemById(id);
        Item[] result = this.track.getAllItem();
        for (Item item : result) {
            if (item != null) {
                System.out.println(item.toString(item));
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // Testing method updateItemById
    private void updateItemByIdTest() {
        System.out.println();
        System.out.println(" 4) Testing method updateItemById:");
        System.out.println(" ---------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id = items[1].getId();
        System.out.println(" -> Update by [id]: " +id);
        Item itemUpdate = new Item("task9", "desc9", this.date.getTime());
        itemUpdate.setId(id);
        this.track.updateItemById(itemUpdate);
        Item[] result = track.getAllItem();
        for (Item item : result) {
            if (item != null) {
                System.out.println(item.toString(item));
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    // Testing method addCommentById
    private void addCommentByIdTest() {
        System.out.println();
        System.out.println(" 5) Testing method addCommentById:");
        System.out.println(" ---------------------------------------------------------------------------");
        Item[] items = this.track.getAllItem();
        String id1 = items[0].getId();
        String id2 = items[1].getId();
        System.out.println(" -> Add comments by [id]: " +id1 +" and " +" [id]: " +id2);
        this.track.addCommentById(id1, new Comment("comm1"));
        this.track.addCommentById(id1, new Comment("comm2"));
        this.track.addCommentById(id1, new Comment("comm3"));
        this.track.addCommentById(id1, new Comment("comm4"));
        this.track.addCommentById(id2, new Comment("comm3"));
        this.track.addCommentById(id2, new Comment("comm2"));
        this.track.addCommentById(id2, new Comment("comm4"));
        Item[] result = track.getAllItem();
        for (Item item : result) {
            if (item != null) {
                System.out.println(item.toString(item));
                for (Comment comm : item.getAllComment()) {
                    if (comm != null) {
                        System.out.println("   - [comm]: " + comm.getComment());
                    }
                }
            }
        }
        System.out.println(" ---------------------------------------------------------------------------");
    }

    public class ConsoleInput {

        private boolean flagExit = true;

        // addItemDefault - add item default by Constructor
        private void addItemDefault() {
            track.addItem(new Item("task0", "desc0", date.getTime()));
            track.addItem(new Item("task1", "desc1", date.getTime()));
            track.addItem(new Item("task2", "desc2", date.getTime()));
            track.addItem(new Item("task3", "desc3", date.getTime()));
        }

        // workItem - work item
        public void workItem() {
            while (this.flagExit) {
                showMenu();
                keyMenu();
            }
            scanner.close();
        }

        // showMenu - shoe manual menu
        public void showMenu() {
            System.out.println("");
            System.out.println("-------- Select move Clinic v 1.00  --------");
            System.out.println("1. Show all Item.");
            System.out.println("2. Add new Item.");
            System.out.println("3. Search Item by id.");
            System.out.println("4. Remove Item by id.");
            System.out.println("5. Update Item by id.");
            System.out.println("6. Add comment by id.");
            System.out.println("7. Exit.");
            System.out.println("--------------------------------------------");
        }

        // keyMenu - select action manual
        public void keyMenu() {
            if (this.flagExit) {
                String scan = scanner.nextLine();
                if (scan.equals("1")) {
                    showAllItem();
                }
                else if (scan.equals("2")) {
                    addItem();
                }
                else if (scan.equals("3")) {
                    searchItemById();
                }
                else if (scan.equals("4")) {
                    removeItemById();
                }
                else if (scan.equals("5")) {
                    updateItemById();
                }
                else if (scan.equals("6")) {
                    addCommentById();
                }
                else if (scan.equals("7")) {
                    this.flagExit = false;
                }
            }

        }

        // showAllItem - show all item, key = "1"
        public void showAllItem() {
            Item[] result = track.getAllItem();
            for (Item item : result) {
                if (item != null) {
                    System.out.println(item.toString(item));

                    for (Comment comm : item.getAllComment()) {
                        if (comm != null) {
                            System.out.println("   - [comm]: " + comm.getComment());
                        }
                    }
                }
            }
        }

        // addNewItem - add new item, key = "2"
        public void addItem() {
            System.out.println("Input name item");
            String name = scanner.nextLine();
            System.out.println("Input description");
            String description = scanner.nextLine();
            //Date date1 = new Date();
            long create = new Date().getTime();
            track.addItem(new Item(name, description, create));
        }
        // findItemById - find item by id, key = "3"
        public void searchItemById() {
            System.out.println("Input id");
            String id = scanner.nextLine();
            Item item = track.searchItemById(id);
            System.out.println(item.toString(item));
        }

        // deleteItemById - delete item by id, key = "4"
        public void removeItemById() {
            System.out.println("Input id");
            String id = scanner.nextLine();
            track.removeItemById(id);
        }

        // updateItemById - update item by id, key = "5"
        public void updateItemById() {
            System.out.println("Input id");
            String id = scanner.nextLine();

            System.out.println("Input name item");
            String name = scanner.nextLine();
            System.out.println("Input description");
            String description = scanner.nextLine();
            long create = new Date().getTime();
            Item item = new Item(name, description, create);
            item.setId(id);
            track.addItem(item);
        }

        // addCommentById - add comment by id, key = "6"
        public void addCommentById() {
            System.out.println("Input id");
            String id = scanner.nextLine();
            System.out.println("Input comment");
            //String comment = scanner.nextLine();
            Comment comment = new Comment(scanner.nextLine());
            track.addCommentById(id, comment);
        }






    }

}
