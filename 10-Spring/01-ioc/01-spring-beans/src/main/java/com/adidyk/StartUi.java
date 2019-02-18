package com.adidyk;

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
        //System.out.println("Test spring");
        //User user = new User("Andros", "Barbos");
        //MemoryStorage memory = new MemoryStorage();
        //JdbcStorage jdbc = new JdbcStorage();
        //UserStorage storage = new UserStorage(memory);
        //storage.add(user);
        //System.out.println(user);orageaog
        //https://javarush.ru/groups/posts/477-spring-dlja-lenivihkh-osnovih-bazovihe-koncepcii-i-primerih-s-koedom-chastjh-2

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");


        /*
        MemoryStorage memory = context.getBean(MemoryStorage.class);
        System.out.println("memory-storage spring");
        memory.add(new User("memory", "memory"));
        */

        System.out.println("jdbc-storage spring");
        JdbcStorage jdbc = context.getBean(JdbcStorage.class);
        jdbc.add(new User("jbdc", "jdbc"));

        System.out.println("user-storage from jdbc-storage spring");
        UserStorage jdbcStorage = context.getBean(UserStorage.class);
        jdbcStorage.add(new User("user-storage from jdbc-storage", "user-storage from jdbc-storage"));

        /*
        System.out.println("user-storage from memory-storage spring");
        UserStorage memoryStorage = context.getBean(UserStorage.class);
        memoryStorage.add(new User("user-storage from memory-storage", "user-storage from memory-storage"));

        /* do not uses spring, I do not create this in spring
        UserStorage memory = new UserStorage(new MemoryStorage());
        memory.add(new User("memory", "memory"));
        UserStorage jdbc = new UserStorage(new JdbcStorage());
        jdbc.add(new User("jdbc", "jdbc"));
        */


    }

}