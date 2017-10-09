package com.adidyk;

import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

/**
 * Class TreeTest for testing methods class "Tree".
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.10.2017.
 * @version 1.0.
 */
public class TreeTest {

    private Tree<User> tree = new Tree<>();

    private User bob = new User("Bob", 2, new GregorianCalendar(1932, 1, 4));
    private User bill = new User("Bill", 3, new GregorianCalendar(1982, 2, 2));
    private User amanda = new User("Amanda", 4, new GregorianCalendar(1242, 4, 5));
    private User dilan = new User("Dilan", 42, new GregorianCalendar(1241, 4, 5));
    private User adolf = new User("Adolf", 3, new GregorianCalendar(1982, 2, 2));
    private User adler = new User("Adler", 2, new GregorianCalendar(1932, 1, 4));
    private User smith = new User("Smith", 4, new GregorianCalendar(1242, 4, 5));
    private User nik = new User("Nik", 4, new GregorianCalendar(1242, 4, 5));
    private User frank = new User("Frank", 4, new GregorianCalendar(1242, 4, 5));
    private User will = new User("Will", 4, new GregorianCalendar(1242, 4, 5));
    private User karl = new User("Karl", 1, new GregorianCalendar(1442, 7, 8));
    private User silver = new User("Silver", 2, new GregorianCalendar(1422, 27, 85));
    private User tramp = new User("Tramp", 21, new GregorianCalendar(1442, 2, 8));


    @Before
    public void init() {
        this.tree.add(bob, bill);
        tree.add(bob, amanda);
        tree.add(bill, dilan);
        tree.add(bill, tramp);
        tree.add(bill, adolf);
        tree.add(amanda, adler);
        tree.add(amanda, smith);
        tree.add(amanda, nik);
        tree.add(adler, frank);
        tree.add(adler, will);
        tree.add(adler, silver);
        tree.add(frank, karl);

    }

    /**
     * addTrueTest - tests method add of class Test when added result is true.
     */
    @Test
    public void addTrueTest() {

    }

}