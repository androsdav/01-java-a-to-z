package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleHashMapTest for testing methods class "User".
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */


public class SimpleHashMapTest {

    /**
     * @param map - reference variable to object of class SimpleHashTable.
     */
    private SimpleHashMap<User, String> map = new SimpleHashMap<>();

    /**
     * @param bill - reference variable to object of class User with params: name, children and birthday.
     */
    private User bill  = new User("Bill", 3, new GregorianCalendar(1982, 2, 2));

    /**
     * @param bob - reference variable to object of class User with params: name, children and birthday.
     */
    private User bob = new User("Bob", 3, new GregorianCalendar(1922, 4, 6));

    /**
     * @param dilan - reference variable to object of class User with params: name, children and birthday.
     */
    private User dilan = new User("Dilan", 4, new GregorianCalendar(1980, 1, 1));

    /**
     * it - iterator.
     */
    private Iterator it = this.map.iterator();

    /**
     * init - adds elements (key and value) in container SimpleHashMap.
     */
    @Before
    public void init() {
        map.put(this.bill, "BILL");
        map.put(this.bob, "BOB");
        map.put(this.dilan, "DILAN");
    }

    /**
     * putNewKeyTest - tests method put of class SimpleHashMap.
     */
    @Test
    public void putNewKeyTest() {
        User ken = new User("Ken", 111, new GregorianCalendar(1933, 4, 7));
        String result = this.map.put(ken, "KEN");
        assertThat(result, is("KEN"));
        assertThat(this.map.get(this.dilan), is("DILAN"));
        assertThat(this.map.get(this.bill), is("BILL"));
        assertThat(this.map.get(this.bob), is("BOB"));
    }

    /**
     * putDuplicateKeyTest - test method put of class SimpleHashMap when inputted key is duplicate and
     * method put return old value.
     */
    @Test
    public void putDuplicateKeyTest() {
        User ken = new User("Ken", 111, new GregorianCalendar(1933, 4, 7));
        map.put(ken, "It is old Ken");
        String result = map.put(ken, "It is new Ken");
        assertThat(result, is("It is old Ken"));
    }

    /**
     * getTrueKeyTest - test method get of class SimpleHashMap when inputted key is true and method get
     * return value.
     */
    @Test
    public void getTrueKeyTest() {
        assertThat("BOB", is(this.map.get(this.bob)));
    }

    /**
     * getFalseKeyTest - test method get of class SimpleHashMap when inputted key is false and method get
     * return null.
     */
    @Test
    public void getFalseKeyTest() {
        User amanda = new User("Amanda", 32, new GregorianCalendar(1986, 3, 2));
        assertThat(null, is(this.map.get(amanda)));
    }

    /**
     * removeTrueKeyTest - test method remove of class SimpleHashMap when inputted key is true and method
     * remove return killed value.
     */
    @Test
    public void removeTrueKeyTest() {
        assertThat("DILAN", is(this.map.remove(this.dilan)));
        assertThat(null, is(this.map.get(this.dilan)));
    }

    /**
     * removeFalseKeyTest - test method remove of class SimpleHashMap when inputted key is false and method
     * remove return null.
     */
    @Test
    public void removeFalseKeyTest() {
        User amanda = new User("Amanda", 32, new GregorianCalendar(1986, 3, 2));
        assertThat(null, is(this.map.remove(amanda)));
    }

    /**
     * sizeTest - test method size of class SimpleHashMap.
     */
    @Test
    public void sizeTest() {
        assertThat(3, is(this.map.size()));
        User amanda = new User("Amanda", 32, new GregorianCalendar(1986, 3, 2));
        User brendon = new User("Brendon", 111, new GregorianCalendar(1933, 4, 7));
        this.map.put(amanda, "AMANDA");
        this.map.put(brendon, "BRENDON");
        assertThat(5, is(this.map.size()));
        this.map.remove(this.bob);
        this.map.remove(this.bill);
        this.map.remove(brendon);
        assertThat(2, is(this.map.size()));
    }

    /**
     * hasNextTrue - test method hasNext when next of class SimpleHashMap value is true.
     */
    @Test
    public void hasNextTrue() {
        this.it.next();
        this.it.next();
        this.it.hasNext();
        assertThat(true, is(this.it.hasNext()));
    }

    /**
     * hasNextFalse - test method hasNext of class SimpleHashMap when next value is false.
     */
    @Test
    public void hasNextFalse() {
        this.it.next();
        this.it.next();
        this.it.next();
        assertThat(false, is(this.it.hasNext()));
    }

}