package com.adidyk;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Iterator;

public class SimpleSetLinkedListTest {

    @Test
    @Ignore
    public void test() {
        System.out.println("test not bad");

        SimpleSetLinkedList<User> set = new SimpleSetLinkedList<>();
        System.out.println(set.add(new User("0", "Marlin", 10)));
        System.out.println(set.add(new User("1", "Dilan", 11)));
        System.out.println(set.add(new User("2", "Arnold", 12)));
        System.out.println(set.add(new User("3", "Argon", 13)));
        System.out.println(set.add(new User("3", "Argon", 13)));
        System.out.println(set.add(new User("4", "Donald", 14)));
        System.out.println(set.add(new User("4", "Donald", 14)));
        System.out.println(set.add(new User("5", "Amanda", 15)));
        System.out.println(set.add(new User("5", "Amanda", 15)));

        Iterator it = set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }


        for(User item : set) {
            System.out.println(item);
        }


    }

}