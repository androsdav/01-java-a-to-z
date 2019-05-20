package com.adidyk.start;

import com.adidyk.input.Input;
import java.sql.SQLException;

/**
 * Interface UserAction contains method: key, execute, info.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public interface UserAction {

    /**
     * key - returns number of index of menu.
     * @return - returns number of index of menu.
     */
    int key();

    /**
     * execute - method implementation.
     * @param input - link variable to object of class ValidateInput.
     * @param storageDAO - link variable to object of class Tracker.
     * @throws SQLException - sql exception.
     */
    void execute(Input input, StorageDAO storageDAO) throws SQLException;

    /**
     * info - returns information about method of execute and number of index of menu.
     * @return - returns information about method of execute and number of index of menu.
     */
    String info();

}