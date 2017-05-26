package com.adidyk.start;

import com.adidyk.models.Account;
import com.adidyk.models.User;

public class StartUi {

    // just main ;), its only for me
    public static void main(String[] arg) {
        System.out.println("Its Bank");
        User user = new User("Albert", "123123313");
        System.out.println(user);

        Account account = new Account(1111222233334444L);

        System.out.println(account.getRequisites() +"   " +account.getValue());
        account.setValue(10);
        System.out.println(account.getRequisites() +"   " +account.getValue());
        account.setValue(20);
        System.out.println(account.getRequisites() +"   " +account.getValue());

      /*  SortUser sorting = new SortUser();
        // Add user to List
        List<User> users = new ArrayList<>();
        users.add(new User("Albert", 17));
        users.add(new User("Carl", 45));
        users.add(new User("Daniel", 16));
        users.add(new User("Leonard", 102));
        users.add(new User("Melvin", 54));
        users.add(new User("Christopher", 33));
        users.add(new User("David", 23));
        users.add(new User("Brandon", 78));
        // Sort Comparator hashCode
        System.out.println();
        System.out.println("Its sort List by use Comparator hashCode:");
        System.out.println();
        List<User> usersHashCode = sorting.sortHash(users);
        for (User user : usersHashCode) {
            System.out.println(user);
        }
        // Sort Comparator name length
        System.out.println();
        System.out.println("Its sort List by use Comparator name length: ");
        System.out.println();
        List<User> userNameLength = sorting.sortLength(users);
        for (User user : userNameLength) {
            System.out.println(user);
        }*/
    }

}