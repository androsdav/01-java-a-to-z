package com.adidyk;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {



        System.out.println("SimpleArray");


        Base user = new User("User", "123");
        Base role = new Role("Role", "234");
        UserOrRoleStore<Base> users = new UserOrRoleStore<>();
        users.add(user);
        users.add(role);

        for (Object item : users.getAll()) {
            System.out.println(item);
        }

        System.out.println(users.getAll());




        SimpleArray<User> test = new SimpleArray<>();
        test.add(new User("user1", "123"));
        test.add(new User("user2", "456"));

        System.out.println(test.getAll());
        for (Object item : test.getAll()) {
            System.out.println(item);

        }





    }

}