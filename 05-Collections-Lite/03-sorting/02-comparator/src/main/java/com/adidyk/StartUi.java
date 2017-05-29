package com.adidyk;

import java.util.ArrayList;
import java.util.List;

public class StartUi {

    // just main ;), its only for me
    public static void main(String[] arg) {
        SortUser sorting = new SortUser();
        // Add user to List
        List<User> users = new ArrayList<>();
        users.add(new User("Albert", 17));
        users.add(new User("Carl", 45));
        users.add(new User("Daniel", 16));
        users.add(new User("Leonardo", 102));
        users.add(new User("Melvin", 54));
        users.add(new User("Christopher", 33));
        users.add(new User("David", 23));
        users.add(new User("Brandon", 78));
        // Sort Comparator hashCode
        System.out.println();
        System.out.println("Its sort List by use Comparator hashCode:");
        System.out.println();
        List<User> usersHashCode = sorting.sortHash(users);
        usersHashCode.forEach(System.out::println);
        // Sort Comparator name length
        System.out.println();
        System.out.println("Its sort List by use Comparator name length: ");
        System.out.println();
        List<User> userNameLength = sorting.sortLength(users);
        userNameLength.forEach(System.out::println);
    }

}