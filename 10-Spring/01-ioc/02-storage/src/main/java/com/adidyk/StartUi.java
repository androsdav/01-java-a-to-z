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
        /*
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Mercedes mercedes = context.getBean(Mercedes.class);
        mercedes.showCar();
        System.out.println(mercedes);
        mercedes = context.getBean(Mercedes.class);
        System.out.println(mercedes);
        */
        User user = new User("andrey", "barmaley");
        System.out.println(user);
    }

}