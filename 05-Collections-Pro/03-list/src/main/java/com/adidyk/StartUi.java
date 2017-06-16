package com.adidyk;

import java.util.Iterator;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {

        System.out.println("SimpleArray and UserStore and RoleStore");

        NewArrayList<User> list = new NewArrayList<>();
        list.add(new User("1", "Bob", 13));
        list.add(new User("2", "Bill", 14));
        list.add(new User("3", "Dragon", 15));

        System.out.println(list);

        Iterator<User> it = list.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());

        /*
        while (it.hasNext()) {
            System.out.println(it.next());

        }
        */
        /*
        for(User item : list) {
            System.out.println(item);

        }
*/
    }


    }

