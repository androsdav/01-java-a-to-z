package com.adidyk;

import com.adidyk.car.Mercedes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {

        User user = new User("andrey", "barmaley");
        System.out.println(user);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Mercedes mercedes = context.getBean(Mercedes.class);
        mercedes.showCar();
        System.out.println(mercedes);
        mercedes = context.getBean(Mercedes.class);
        System.out.println(mercedes);
        //JdbcStorage store = context.getBean(JdbcStorage.class);
        //store.setDataSource();
        //store.add(new User("test_name", "test_login"));
        // user stirage
        UserStorage storage = context.getBean(UserStorage.class);
        //storage.addUser(new User("alex", "babiny"));
        //storage.removeUserById("10");
        System.out.println("Result:" );
        System.out.println(storage.getUserById("2"));
        System.out.println("Result update:" );
        User newUser = new User("ne_alex", "ne_babiny");
        newUser.setId("11");
        storage.updateUserById(newUser);
        for (User item : storage.getAllUser()) {
            System.out.println(item);
        }
        System.out.println("Result login:");
        for (User item : storage.getAllUserByLogin("alex")) {
            System.out.println(item);
        }

        System.out.println("Result name:");
        for (User item : storage.getAllUserByName("babiny")) {
            System.out.println(item);
        }

        System.out.println("Result login and name:");
        for (User item : storage.getAllUserByLoginByName("alex", "babiny")) {
            System.out.println(item);
        }

    }

}