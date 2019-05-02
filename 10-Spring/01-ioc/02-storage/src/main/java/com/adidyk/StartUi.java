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
        storage.addUser(new User("alex", "babiny"));
        //storage.removeUserById("10");
        System.out.println(storage.getUserById("2"));

    }

}