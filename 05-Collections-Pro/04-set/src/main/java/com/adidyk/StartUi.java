package com.adidyk;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {
        SimpleSetArray<User> set = new SimpleSetArray<>();

        System.out.println(set.add(new User("0", "0", 0)));
        //System.out.println(set.add(new User("1", "1", 1)));
        //System.out.println(set.add(new User("2", "2", 2)));
        //System.out.println(set.add(new User("3", "3", 3)));
        //System.out.println(set.add(new User("4", "4", 4)));
        //System.out.println(set.add(new User("5", "5", 5)));


        for(int index = 0; index < set.size(); index++) {
           System.out.println(set.get(index));
        }
    }

}

