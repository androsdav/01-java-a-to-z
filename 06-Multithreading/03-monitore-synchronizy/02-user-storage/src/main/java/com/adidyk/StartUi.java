package com.adidyk;

//import java.awt.*;

/** Class User for create user (object) with params: id, amount.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.07.2017.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - just main.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        System.out.println("");
        System.out.println("Hello UserStorage");
        User first = new User(1, 100);
        User second = new User(2, 200);
        System.out.println("result: " + first);
        System.out.println("result: " + second);
        UserStorage<User> storage = new UserStorage<>(3);
        System.out.println(" " + storage.add(new User(1, 10)));
        System.out.println(" " + storage.add(new User(2, 20)));
        System.out.println(" " + storage.add(new User(3, 30)));
        System.out.println(storage);
        System.out.println(" " + storage.add(new User(4, 40)));
        System.out.println(" " + storage.add(new User(3, 30)));
        System.out.println(storage);
        System.out.println(storage.delete(new User(4, 40)));
        System.out.println(storage);
    }

}
