package com.adidyk.constant;

import com.adidyk.setup.Setup;

/**
 * Class Constant for create all constants.
 * All constants are created when reading from the configuration file app.properties.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class Constant {

      /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static String ADD_USER;

    /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static String SEARCH_USER_BY_ID;

    /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static String SEARCH_USER_BY_NAME;

    /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static String SEARCH_USER_BY_LOGIN;

    /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static String SEARCH_USER_BY_LOGIN_BY_NAME;

    /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static String UPDATE_USER_BY_ID;

    /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static String REMOVE_USER_BY_ID;

    /**
     * @param ADD_ITEM - query sql: add item (from app.properties).
     */
    public static String GET_ALL_USER;


    /**
     * Constant - constructor (reads all parameters from file app.properties).
     * @param setup - link to object of class Setting.
     */
    public Constant(Setup setup) {

        ADD_USER = setup.getValue("app.addUser");
        SEARCH_USER_BY_ID = setup.getValue("app.searchUserById");
        SEARCH_USER_BY_NAME = setup.getValue("app.searchUserByName");
        SEARCH_USER_BY_LOGIN = setup.getValue("app.searchUserByLogin");
        SEARCH_USER_BY_LOGIN_BY_NAME = setup.getValue("app.searchUserByLoginByName");
        UPDATE_USER_BY_ID = setup.getValue("app.updateUserById");
        REMOVE_USER_BY_ID = setup.getValue("app.removeUserById");
        GET_ALL_USER = setup.getValue("app.getAllUser");
    }

    /**
     * menuTable - displays menu table.
     */
    public static void menuTable() {
        System.out.println("\n -----------USER-STORAGE-MENU-------------");
    }

    /**
     * menuSeparator - displays menu separator.
     */
    public static void menuSeparator() {
        System.out.println(" -----------------------------------------");
    }

    /**
     * itemTable - displays table item.
     */
    public static void userTable() {
        System.out.println(String.format("\n %s%6s%3s %18s%12s %20s%17s",
                "|", "ID", "|", "LOGIN", "|", "NAME", "|"));
        System.out.println(" |--------|------------------------------|-------------------------------------|");
    }

    /**
     * itemSeparator - displays item separator.
     */
    public static void userSeparator() {
        System.out.println(" |--------|------------------------------|-------------------------------------|");
    }

}