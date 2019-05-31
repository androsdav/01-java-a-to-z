package com.adidyk.start;

import com.adidyk.input.Input;
import com.adidyk.input.ValidateInput;
import com.adidyk.setup.RunSetup;
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
        context.getBean(RunSetup.class);
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
    }

}