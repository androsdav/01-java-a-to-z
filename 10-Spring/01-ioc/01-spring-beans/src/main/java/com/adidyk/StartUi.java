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
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memory = context.getBean(MemoryStorage.class);
        System.out.println("memory-storage spring");
        memory.add(new User("memory", "memory"));
        System.out.println("jdbc-storage spring");
        JdbcStorage jdbc = (JdbcStorage) context.getBean("jdbc");
        jdbc.add(new User("jbdc", "jdbc"));
        System.out.println("user-storage from jdbc-storage spring");
        UserStorage jdbcStorage = context.getBean(UserStorage.class);
        jdbcStorage.add(new User("user-storage from jdbc-storage", "user-storage from jdbc-storage"));
    }

}