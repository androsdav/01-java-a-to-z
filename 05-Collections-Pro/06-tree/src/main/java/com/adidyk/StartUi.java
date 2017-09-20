package com.adidyk;

import java.util.GregorianCalendar;

/**
 * Class "StartUi" for create Map and puts key = user and value = new Object().
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - is only for create jar file.
     * @param arg nothing.
     */
    public static void main(String[] arg) {

        /*
        System.out.println("SimpleHashMap");
        System.out.println("Tree");
        TreeMap<String, String> tree = new TreeMap<>();
        tree.put("BOB1", "Madly1");
        tree.put("BOB2", "Madly2");
        tree.put("BOB3", "Madly3");
        System.out.println(tree);
        for (Map.Entry<String, String> item : tree.entrySet()) {
            System.out.println("key: " + item.getKey() +  " value: " + item.getValue());
        }
        */
/*
        User bill = new User("Bill", 3, new GregorianCalendar(1982, 2, 2));
        User bob = new User("Bob", 2, new GregorianCalendar(1932, 1, 4));
        User dilan1 = new User("Dilan", 42, new GregorianCalendar(1241, 4, 5));
        User dilan2 = new User("Dilan", 43, new GregorianCalendar(1240, 4, 5));
        User dilan3 = new User("Dilan", 41, new GregorianCalendar(1247, 4, 5));
        User dilan4 = new User("Dilan", 40, new GregorianCalendar(1239, 4, 5));
        User adolf = new User("Adolf", 3, new GregorianCalendar(1982, 2, 2));
        User adler = new User("Adler", 2, new GregorianCalendar(1932, 1, 4));
        User smith = new User("Smith", 4, new GregorianCalendar(1242, 4, 5));
        User amanda = new User("Amanda", 4, new GregorianCalendar(1242, 4, 5));
        TreeSet<User> listing = new TreeSet<>();
        listing.add(dilan4);
        listing.add(amanda);
        listing.add(smith);
        listing.add(dilan3);
        listing.add(bill);
        listing.add(adler);
        listing.add(bob);
        listing.add(dilan1);
        listing.add(adolf);
        listing.add(dilan2);

        for (User item : listing) {
            System.out.println(item);
        }
        //Hashtable<String, String> table = new Hashtable<>();
*/
        User bob = new User("Bob", 2, new GregorianCalendar(1932, 1, 4));
        User bill = new User("Bill", 3, new GregorianCalendar(1982, 2, 2));
        User amanda = new User("Amanda", 4, new GregorianCalendar(1242, 4, 5));
        User dilan = new User("Dilan", 42, new GregorianCalendar(1241, 4, 5));
        User adolf = new User("Adolf", 3, new GregorianCalendar(1982, 2, 2));
        User adler = new User("Adler", 2, new GregorianCalendar(1932, 1, 4));
        User smith = new User("Smith", 4, new GregorianCalendar(1242, 4, 5));
        User nik = new User("Nik", 4, new GregorianCalendar(1242, 4, 5));
        User frank = new User("Frank", 4, new GregorianCalendar(1242, 4, 5));
        User will = new User("Will", 4, new GregorianCalendar(1242, 4, 5));
        Tree<User> tree = new Tree<>();
        //tree.add(bob, adolf);
        tree.add(bob, bob);
        tree.add(bob, bill);
        tree.add(bob, amanda);
        tree.add(bill, dilan);
        tree.add(bill, adolf);
        tree.add(amanda, adler);
        tree.add(amanda, smith);
        tree.add(dilan, nik);
        tree.add(dilan, frank);
        tree.add(dilan, will);
//        tree.add(amanda, smith);
//        tree.add(bill, dilan);
//        tree.add(bill, adolf);

        System.out.print("Bob : ");
        for (Object node : tree.getChildrenByParent(bob)) {
            if (node != null) {
                System.out.print(" " + node);
            }
        }
        System.out.println();

        System.out.print("Bill : ");
        for (Object node : tree.getChildrenByParent(bill)) {
            if (node != null) {
                System.out.print(" " + node);
            }
        }
        System.out.println();

        System.out.print("Amanda : ");
        for (Object node : tree.getChildrenByParent(amanda)) {
            if (node != null) {
                System.out.print(" " + node);
            }
        }
        System.out.println();

        System.out.print("Dilan : ");
        for (Object node : tree.getChildrenByParent(dilan)) {
            if (node != null) {
                System.out.print(" " + node);
            }
        }
        System.out.println();






        //       tree.add(dilan, adolf);
 //       tree.add(adolf, adler);
 //       tree.add(adolf, smith);
 //       tree.add(smith, amanda);



    }

}