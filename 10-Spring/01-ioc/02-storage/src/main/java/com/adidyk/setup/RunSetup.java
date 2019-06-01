package com.adidyk.setup;

import com.adidyk.constant.Constant;
import com.adidyk.input.ValidateInput;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class of RunSetup use to load file from input stream and return parameter by key from file configure app.properties.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 04.09.2018.
 * @version 1.0.
 */
public class RunSetup {

    /**
     * @param logger - logger (link variable to object of class Logger).
     */
    private static final Logger logger = Logger.getLogger(ValidateInput.class);

    /**
     * setSetup - loads params from file app.properties.
     * @param setup - link variable to object of class Setup.
     */
    public void setSetup (Setup setup) {
        ClassLoader loader = Setup.class.getClassLoader();
        try (
                InputStream is = loader.getResourceAsStream("app.properties")) {
            setup.load(is);
            new Constant(setup);
        } catch (
                IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

}