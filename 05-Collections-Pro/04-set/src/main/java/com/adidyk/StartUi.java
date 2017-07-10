package com.adidyk;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {
        System.out.println("SimpleSetArrays, SimpleSetLinkedList");

//        User user = new User("1", "Bill", 10);
//        User user1 = new User("1", "Bill", 11);

//        System.out.println(user);
  //      System.out.println(user1);

        System.out.println("Its my collections");
        SimpleSetArray<User> set = new SimpleSetArray<>();
        set.add(new User("00", "A", 0));
        set.add(new User("01", "B", 1));
        set.add(new User("02", "C", 2));
        set.add(new User("03", "D", 3));
        set.add(new User("04", "I", 4));
        set.add(new User("05", "F", 5));
        set.add(new User("06", "G", 6));
        set.add(new User("07", "E", 7));
        set.add(new User("08", "K", 8));
        set.add(new User("09", "L", 9));
        set.add(new User("10", "M", 10));



        for (User item : set) {
            System.out.println(item);
        }

        /*
        System.out.println("Comparable");
        Set<User> test = new TreeSet<>();
        test.add(new User("0", "bob", 0));
        test.add(new User("1", "bib", 1));
        test.add(new User("2", "neo", 2));
        test.add(new User("1", "bib", 1));
        test.add(new User("1", "bib", 1));
        test.add(new User("1", "bib", 1));
        test.add(new User("2", "donald", 2));
        test.add(new User("3", "bolt", 1));
        test.add(new User("4", "dilan", 1));
        test.add(new User("5", "amanda", 1));

        for(User item : test) {
            System.out.println(item);
        }

*/
    }

}