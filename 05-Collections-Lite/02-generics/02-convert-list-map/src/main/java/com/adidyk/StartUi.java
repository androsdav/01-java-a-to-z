package com.adidyk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StartUi {

    public static void main(String[] arg) {
        System.out.println("User");

        List<User> list = new ArrayList<>();
        list.add(new User(1, "Tom", "New-York"));
        list.add(new User(2, "Bill", "Atlanta"));
        list.add(new User(3, "Kelly", "Santa-Barbara"));
        list.add(new User(4, "Brook", "Chicago"));
        list.add(new User(5, "Bolt", "Dallas"));

        UserConvert user = new UserConvert();
        Map<Integer, User> mapUser = user.process(list);

        for (Map.Entry<Integer, User> item : mapUser.entrySet()) {
            System.out.println("key: " +item.getKey() +" name: " +item.getValue().getName() +" city: " +item.getValue().getCity());
        }
    }

}