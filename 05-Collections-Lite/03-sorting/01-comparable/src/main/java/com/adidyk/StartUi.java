package com.adidyk;

import java.util.ArrayList;

public class StartUi {

    public static void main(String[] arg) {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("andrey", 35));
        users.add(new User("antony", 32));
        users.add(new User("bill", 45));
        users.add(new User("bob", 15));
        users.add(new User("smith", 5));
        users.add(new User("will", 10));

        System.out.println("Classic loop for");
        for (int index = 0; index < users.size(); index++) {
            System.out.println("Name: " + users.get(index).getName() + "age: " + users.get(index).getAge());
        }

        System.out.println("Classic loop for-ich");
        for (User user : users) {
            System.out.println("Name: " + user.getName() + "age: " + user.getAge());
        }

        System.out.println("Classic loop for-ich with toString");

    }

}