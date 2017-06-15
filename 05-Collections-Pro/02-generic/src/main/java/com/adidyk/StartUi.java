package com.adidyk;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {



        System.out.println("SimpleArray");


        User user = new User("Vasya", "123");
        UserOrRoleStore<User> users = new UserOrRoleStore<>();
        users.add(user);

        for (Object item : users.getAll()) {
            System.out.println(item);
        }





    }

}