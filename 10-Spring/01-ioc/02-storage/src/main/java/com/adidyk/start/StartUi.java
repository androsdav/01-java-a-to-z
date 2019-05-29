package com.adidyk.start;

import com.adidyk.constant.Constant;
import com.adidyk.input.Input;
import com.adidyk.input.ValidateInput;
import com.adidyk.setup.Setup;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class StartUi {

    /**
     * @param logger - link variable to object of class Logger.
     */
    private static final Logger logger = Logger.getLogger(StartUi.class);


    /**
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {



        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        Input input = context.getBean(ValidateInput.class);
        while (true) {
            storage.show();
            int key = input.ask(" Choose key: ", storage.getIndexActions());
            storage.select(key);
            if (key == storage.getIndexActions().length) {
                break;
            }
        }

        //UserStorage.ShowAllUser showAllUser = new UserStorage.ShowAllUser();
        //TestAction testAction = context.getBean(TestAction.class);
        ///System.out.println(testAction.info());
        //BaseAction action = context.getBean(BaseAction.class);
        //TestAction testAction = new TestAction("test");
        //System.out.println(testAction.info());

        //UserStorage.ShowAllUser action = context.getBean(UserStorage.ShowAllUser.class);
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