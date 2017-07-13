package com.adidyk;

import java.util.GregorianCalendar;
import java.util.HashMap;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {

        //System.out.println("SimpleSetArrays - uses binary search duplicate, SimpleSetLinkedList");

        //Calendar data = Calendar.getInstance();

/*
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar(1982, 8, 9);
        System.out.println(sdf.format(calendar.getTime()));

        System.out.println("Map");

        Map<User, Object> map = new HashMap<>();

        User firstBill = new User("Bill", 3, new GregorianCalendar(1982, 8, 9));
        User secondBill = new User("Bill", 3, new GregorianCalendar(1982, 8, 9));

        map.put(firstBill, new Object());
        map.put(secondBill, new Object());

        System.out.println(map);

  */

        System.out.println();
        HashMap<Integer, User> map = new HashMap<>(20);

        System.out.println(map.put(1, new User("Bob", 0, new GregorianCalendar(1999, 1, 1))));
//        map.put(2, new User("Bil", 1, new GregorianCalendar(2000, 1, 1)));









//        System.out.println(firstBill);
  //      System.out.println(secondBill);

    }

}