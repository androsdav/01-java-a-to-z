package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import java.util.*;

public class StartUi {

    private Input input;

    public StartUi(Input input) {
        this.input = input;

    }

    public void init(){
     //   ConsoleInput input = new ConsoleInput();
        //String name = this.input.ask("Input name item:");
        //String desc = this.input.ask("Input desc item:");
        //Tracker track = new Tracker();
        //track.addItem(new Item(name, desc, new Date().getTime()));
        //for (Item item : track.getAllItem()) {
        //    if (item != null) {
        //        System.out.println(item.toString());
        //    }
       // }

        String[] answers ={"test0","test1", "test2"};
        //StubInput stub = new StubInput(answers);
        String test = this.input.ask("Provarka rabotu hz");
        System.out.println("Output:    "  +test);
    }


    public static void main(String[] args) {
       //StartUi start = new StartUi();
       //start.init();
        Input input = new StubInput(new String[] {"create stub task"});
        new StartUi(input).init();
    }
}
    /*
    private Tracker track = new Tracker();
    private Scanner scanner = new Scanner(System.in);
    private ConsoleInput input = new ConsoleInput();
    private boolean flagExit = true;

    // Main
    public static void main(String[] arg) {
        StartUi start = new StartUi();
        System.out.println();
        System.out.println(" ---------------------------------------------------------------------------");
        System.out.println("                          << Tracker ver. 1.0 >> ");
        System.out.println("                     it provides to work with program ");
        System.out.println("                         for accounting of statement");
        System.out.println(" ---------------------------------------------------------------------------");
        start.workItem();
    }

    // workItem - work item
    private void workItem() {
        input.addItemDefault();
        while (this.flagExit) {
            input.showMenu();
            input.keyMenu();
        }
        scanner.close();
    }

    // class ConsoleInput
    private class ConsoleInput {

        private void addItemDefault() {
            track.addItem(new Item("task0", "desc0", new Date().getTime()));
            track.addItem(new Item("task1", "desc1", new Date().getTime()));
            track.addItem(new Item("task2", "desc2", new Date().getTime()));
            track.addItem(new Item("task3", "desc3", new Date().getTime()));
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
                String scan = scanner.nextLine();
                switch (scan) {
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

        // addNewItem - add new item, key = " 2 "
        private void addItem() {
            System.out.print(" Input name item: ");
            String name = scanner.nextLine();
            System.out.print(" Input description item: ");
            String description = scanner.nextLine();
            long create = new Date().getTime();
            track.addItem(new Item(name, description, create));
        }

        // findItemById - find item by id, key = " 3 "
        private void searchItemById() {
            System.out.print(" Input id: ");
            String id = scanner.nextLine();
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
            System.out.print(" Input name: ");
            String name = scanner.nextLine();
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

        // searchItemByName - find item by sub description, key = " 5 "
        private void searchItemByDescription() {
            System.out.print(" Input description: ");
            String desc = scanner.nextLine();
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
            System.out.print(" Input id: ");
            String id = scanner.nextLine();
            track.removeItemById(id);
        }

        // updateItemById - update item by id, key = " 7 "
        private void updateItemById() {
            System.out.print(" Input id: ");
            String id = scanner.nextLine();
            System.out.print(" Input new name item: ");
            String name = scanner.nextLine();
            System.out.print(" Input new description: ");
            String description = scanner.nextLine();
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
            System.out.print(" Input id: ");
            String id = scanner.nextLine();
            System.out.print(" Input comment: ");
            Comment comment = new Comment(scanner.nextLine());
            track.addCommentById(id, comment);
        }

    }
*/
