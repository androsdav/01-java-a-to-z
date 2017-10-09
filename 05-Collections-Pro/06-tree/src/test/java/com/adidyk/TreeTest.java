package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TreeTest for testing methods class "Tree".
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.10.2017.
 * @version 1.0.
 */
public class TreeTest {

    /**
     * @param tree - reference variable to object of class Tree.
     */
    private Tree<User> tree = new Tree<>();

    /**
     * @param bob - reference variable to object of class User with params: name, children and birthday.
     */
    private User bob = new User("Bob", 2, new GregorianCalendar(1932, 1, 4));

    /**
     * @param bill - reference variable to object of class User with params: name, children and birthday.
     */
    private User bill = new User("Bill", 3, new GregorianCalendar(1982, 2, 2));

    /**
     * @param amanda - reference variable to object of class User with params: name, children and birthday.
     */
    private User amanda = new User("Amanda", 4, new GregorianCalendar(1242, 4, 5));

    /**
     * @param dilan - reference variable to object of class User with params: name, children and birthday.
     */
    private User dilan = new User("Dilan", 42, new GregorianCalendar(1241, 4, 5));

    /**
     * @param adolf - reference variable to object of class User with params: name, children and birthday.
     */
    private User adolf = new User("Adolf", 3, new GregorianCalendar(1982, 2, 2));

    /**
     * @param adler - reference variable to object of class User with params: name, children and birthday.
     */
    private User adler = new User("Adler", 2, new GregorianCalendar(1932, 1, 4));

    /**
     * @param smith - reference variable to object of class User with params: name, children and birthday.
     */
    private User smith = new User("Smith", 4, new GregorianCalendar(1242, 4, 5));

    /**
     * @param nik - reference variable to object of class User with params: name, children and birthday.
     */
    private User nik = new User("Nik", 4, new GregorianCalendar(1242, 4, 5));

    /**
     * @param frank - reference variable to object of class User with params: name, children and birthday.
     */
    private User frank = new User("Frank", 4, new GregorianCalendar(1242, 4, 5));

    /**
     * @param will - reference variable to object of class User with params: name, children and birthday.
     */
    private User will = new User("Will", 4, new GregorianCalendar(1242, 4, 5));

    /**
     * @param karl - reference variable to object of class User with params: name, children and birthday.
     */
    private User karl = new User("Karl", 1, new GregorianCalendar(1442, 7, 8));

    /**
     * @param silver - reference variable to object of class User with params: name, children and birthday.
     */
    private User silver = new User("Silver", 2, new GregorianCalendar(1422, 27, 85));

    /**
     * @param tramp - reference variable to object of class User with params: name, children and birthday.
     */
    private User tramp = new User("Tramp", 21, new GregorianCalendar(1442, 2, 8));

    /**
     * it - iterator.
     */
    private Iterator<User> it;


    /**
     * init - adds object of class User to Tree.
     */
    @Before
    public void init() {
        this.tree.add(this.bob, this.bill);
        this.tree.add(this.bob, this.amanda);
        this.tree.add(this.bill, this.dilan);
        this.tree.add(this.bill, this.tramp);
        this.tree.add(this.bill, this.adolf);
        this.tree.add(this.amanda, this.adler);
        this.tree.add(this.amanda, this.smith);
        this.tree.add(this.amanda, this.nik);
        this.tree.add(this.adler, this.frank);
        this.tree.add(this.adler, this.will);
        this.tree.add(this.adler, this.silver);
        this.tree.add(this.frank, this.karl);
        this.it = this.tree.iterator();
    }

    /**
     * addTrueTest - tests method add of class Tree when added result is true.
     */
    @Test
    public void addTrueTest() {
        User abigail = new User("Abigale", 3, new GregorianCalendar(1999, 1, 2));
        assertThat(true, is(this.tree.add(this.frank, abigail)));
    }

    /**
     * addFalseTest - tests method add of class Tree when added result is false.
     */
    @Test
    public void addFalseTest() {
        User karl = new User("Karl", 1, new GregorianCalendar(1442, 7, 8));
        assertThat(false, is(this.tree.add(adolf, karl)));
    }

    /**
     * sizeTest - tests method size of class Tree.
     */
    @Test
    public void sizeTest() {
        assertThat(13, is(this.tree.size()));
        User abigail = new User("Abigale", 3, new GregorianCalendar(1999, 1, 2));
        this.tree.add(this.frank, abigail);
        assertThat(14, is(this.tree.size()));
        User karl = new User("Karl", 1, new GregorianCalendar(1442, 7, 8));
        this.tree.add(adolf, karl);
        assertThat(14, is(this.tree.size()));
    }

    /**
     * hasNextTrue - test method hasNext when next of class Tree.
     */
    @Test
    public void hasNextTrue() {
        this.it.next();
        this.it.next();
        this.it.hasNext();
        assertThat(true, is(this.it.hasNext()));
    }

    /**
     * hasNextFalse - test method hasNext of class Tree.
     */
    @Test
    public void hasNextFalse() {
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        assertThat(false, is(this.it.hasNext()));
    }

    /**
     * nextTest - test method next() of class Tree (iterator).
     */
    @Test
    public void nextTest() {
        this.it.next();
        assertThat(this.it.next(), is(new User("Bill", 3, new GregorianCalendar(1982, 2, 2))));
        this.it.next();
        assertThat(this.it.next(), is(new User("Dilan", 42, new GregorianCalendar(1241, 4, 5))));
    }

    /**
     * loopTest - test iterator (forEach) of class Tree (iterator).
     */
    @Test
    public void loopTest() {
        ArrayList<User> treeActual = new ArrayList<>();
        treeActual.add(new User("Bob", 2, new GregorianCalendar(1932, 1, 4)));
        treeActual.add(new User("Bill", 3, new GregorianCalendar(1982, 2, 2)));
        treeActual.add(new User("Amanda", 4, new GregorianCalendar(1242, 4, 5)));
        treeActual.add(new User("Dilan", 42, new GregorianCalendar(1241, 4, 5)));
        treeActual.add(new User("Adolf", 3, new GregorianCalendar(1982, 2, 2)));
        treeActual.add(new User("Tramp", 21, new GregorianCalendar(1442, 2, 8)));
        treeActual.add(new User("Adler", 2, new GregorianCalendar(1932, 1, 4)));
        treeActual.add(new User("Smith", 4, new GregorianCalendar(1242, 4, 5)));
        treeActual.add(new User("Nik", 4, new GregorianCalendar(1242, 4, 5)));
        treeActual.add(new User("Frank", 4, new GregorianCalendar(1242, 4, 5)));
        treeActual.add(new User("Will", 4, new GregorianCalendar(1242, 4, 5)));
        treeActual.add(new User("Silver", 2, new GregorianCalendar(1422, 27, 85)));
        treeActual.add(new User("Karl", 1, new GregorianCalendar(1442, 7, 8)));
        int position = 0;
        while (this.it.hasNext()) {
            assertThat(this.it.next(), is(treeActual.get(position)));
            position++;
        }
    }

}