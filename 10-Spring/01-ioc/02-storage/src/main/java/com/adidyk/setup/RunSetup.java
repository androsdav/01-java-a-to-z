package com.adidyk.setup;

import com.adidyk.constant.Constant;
import com.adidyk.input.ValidateInput;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;

public class RunSetup {

    /**
     * @param logger - logger.
     */
    private static final Logger logger = Logger.getLogger(ValidateInput.class);

    /**
     *
     */
    private Setup setup;

    /**
     *
     * @param setup - setup.
     */
    RunSetup(Setup setup) {
        this.setup = setup;
    }

    /**
     *
     */
    public void load () {
        Setup setup = new Setup();
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