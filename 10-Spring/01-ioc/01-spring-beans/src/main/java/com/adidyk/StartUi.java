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
        //System.out.println(user);
        //https://javarush.ru/groups/posts/477-spring-dlja-lenivihkh-osnovih-bazovihe-koncepcii-i-primerih-s-kodom-chastjh-2
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memory = context.getBean(MemoryStorage.class);
        memory.add(new User("user", "luser"));
    }

}