package com.adidyk.start;

import com.adidyk.input.Input;
import java.sql.SQLException;

/**
 * Interface UserAction contains method: key, execute, info.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public abstract class BaseAction implements UserAction {

    /**
     * @param name - description of method execute.
     */
    private String name;

    /**
     * BaseAction - constructor.
     * @param name - description of method execute.
     */
    BaseAction(String name) {
        this.name = name;
    }

    /**
     * key - returns number of index of menu.
     * @return - returns number of index of menu.
     */
    @Override
    public abstract int key();

    /**
     * execute - method implementation.
     * @param input - link variable to object of class ValidateInput.
     * @param storageDAO - link variable to object of class Tracker.
     * @throws SQLException - sql exception.
     */
    @Override
    public abstract void execute(Input input, StorageDAO storageDAO) throws SQLException;

    /**
     * info - returns information about method of execute and number of index of menu.
     * @return - returns information about method of execute and number of index of menu.
     */
    @Override
    public String info() {
        return String.format(" %s%s%s", this.key(), ".", this.name);
    }

}