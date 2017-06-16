package com.adidyk;

public class StartUi {

    // main - its only for compile jar file
    public static void main(String[] arg) {



        System.out.println("SimpleArray");

        UserStore<User> listUser = new UserStore<>();
        listUser.add(new User("123", "Ivan", 15));
        listUser.add(new User("124", "Vano", 14));
        listUser.add(new User("125", "Petr", 12));
        listUser.add(new User("126", "Dima", 17));
        listUser.add(new User("127", "Leha", 19));

        System.out.println();
        for (Object item : listUser.getAll()) {
            System.out.println(item);
        }

        System.out.println();
        listUser.remove(new User("123", "Ivan", 15));
        for (Object item : listUser.getAll()) {
            System.out.println(item);
        }


/*
        UserStore<Role> listRole = new UserStore<>();
        listRole.add(new Role("124", "Ruslan"));
        listRole.add(new Role("114", "Rusl"));
        listRole.add(new Role("125", "Rusn"));
        listRole.add(new Role("122", "Rusl"));

        for (Object item : listRole.getAll()) {
            System.out.println(item);
        }

        System.out.println();
        listRole.remove(3);

        for (Object item : listRole.getAll()) {
            System.out.println(item);
        }


/*

        User user = new User("User", "123");
        Role role = new Role("Role", "234");
        UserOrRoleStore<User> users = new UserOrRoleStore<>();
        users.add(user);
        //users.add(role);

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



*/

    }

}