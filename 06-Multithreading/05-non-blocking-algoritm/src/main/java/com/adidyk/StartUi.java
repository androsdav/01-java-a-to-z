package com.adidyk;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 05.05.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program only for create jar file.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        System.out.println("Non blocking algorithm");
        Cache cache = new Cache();
        cache.add(new User(1, "Tom", "operator"));
        cache.add(new User(2, "Bob", "administrator"));
        cache.add(new User(3, "Bill", "admin"));
        boolean user = cache.update(new User(2, "Amanda", "bitch"));
        System.out.println(user);
        System.out.println(cache.get(2));
        boolean user1 = cache.update(new User(2, "Blablabla", "bitch2"));
        System.out.println(user1);
        System.out.println(cache.get(2));
        //System.out.println(cache.get(2));
        boolean user2 = cache.update(new User(4, "Merlin", "demon"));
        System.out.println(user2);
    }

}