package com.adidyk.start;

import com.adidyk.input.Input;
import com.adidyk.input.ValidateInput;
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


        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        /*
        Input input = context.getBean(ValidateInput.class);
        while (true) {
            storage.show();
            int key = input.ask(" Choose key: ", storage.getIndexActions());
            storage.select(key);
            if (key == storage.getIndexActions().length) {
                break;
            }
        }

        /*

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
        */

    }

}