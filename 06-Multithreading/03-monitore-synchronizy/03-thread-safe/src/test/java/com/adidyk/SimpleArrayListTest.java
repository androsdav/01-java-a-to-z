package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleArrayList does testing method of class SimpleArrayList.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
public class SimpleArrayListTest {

    /**
     * @param list - is reference variable to object of class SimpleArrayList.
     */
    private SimpleArrayList<User> list = new SimpleArrayList<>(10);

    /**
     * @param tom - is reference variable to object of class User.
     */
    private User tom;
    /**
     * @param bill - is reference variable to object of class User.
     */
    private User bill;

    /**
     * @param bob - is reference variable to object of class User.
     */
    private User bob;

    /**
     * @param it - is reference variable to object of class Iterator.
     */
    private Iterator it;

    /**
     * init - initialisation all parameters and adds new user to container list.
     */
    @Before
    public void init() {
        this.tom = new User("1", "Tom", 17);
        this.bill = new User("2", "Bill", 18);
        this.bob = new User("3", "Bob", 20);
        this.list.add(new User("1", "Tom", 17));
        this.list.add(new User("2", "Bill", 18));
        this.list.add(new User("3", "Bob", 20));
        this.it = list.iterator();
    }

    /**
     * addTest - tests method add of class SimpleArrayList.
     */
    @Test
    public void addTest() {
        Object[] objects = new Object[] {this.tom, this.bill, this.bob};
        assertThat(objects, is(this.list.getAll()));
    }

    /**
     * getTest - tests method get of class SimpleArrayList.
     */
    @Test
    public void getTest() {
        assertThat(new User("3", "Bob", 20), is(this.list.get(2)));
    }

    /**
     * getAllTest - tests method getAll of class SimpleArrayList.
     */
    @Test
    public void getAllTest() {
        User evan = new User("6", "Evan", 33);
        this.list.add(new User("6", "Evan", 33));
        Object[] objects = new Object[] {this.tom, this.bill, this.bob, evan};
        assertThat(objects, is(this.list.getAll()));
    }

    /**
     * sizeTest - tests method size of class SimpleArrayList.
     */
    @Test
    public void sizeTest() {
        assertThat(3, is(this.list.size()));
    }

    /**
     * forEachTest - tests method forEach of class SimpleArrayList.
     */
    @Test
    public void forEachTest() {
        Object[] resultActual = new Object[] {new User("1", "Tom", 17),
                new User("2", "Bill", 18), new User("3", "Bob", 20)};
        Object[] resultExpected = new Object[3];
        int index = 0;
        for (Object user : this.list.getAll()) {
            resultExpected[index++] = user;
        }
        assertThat(resultActual, is(resultExpected));
    }

    /**
     * nextTest - it tests method next for iterator when next element from container is true.
     */
    @Test
    public void nextTest() {
        this.it.next();
        assertThat(new User("2", "Bill", 18), is(this.it.next()));
    }

    /**
     * hasNextTest - it tests method hasNext for iterator when next element from container is true.
     */
    @Test
    public void hasNextTrue() {
        this.it.next();
        this.it.next();
        this.it.hasNext();
        assertThat(true, is(this.it.hasNext()));
    }

    /**
     * hasNextTest - it tests method hasNext for iterator when next element from container is false.
     */
    @Test
    public void hasNextFalse() {
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.hasNext();
        assertThat(false, is(this.it.hasNext()));
    }

    /**
     * loopTest - it test loop for iterator.
     */
    @Test
    public void loopTest() {
        Object[] resultActual = new Object[] {new User("1", "Tom", 17),
                new User("2", "Bill", 18), new User("3", "Bob", 20)};
        Object[] resultExpected = new Object[3];
        int index = 0;
        while (this.it.hasNext()) {
            resultExpected[index++] = this.it.next();
        }
        assertThat(resultActual, is(resultExpected));
    }

    /**
     * modCount - it tests concurrent modification exception.
     */
    @Test
    public void modCount() {
        try {
            this.list.add(new User("11", "Anton", 123));
            it.next();
        } catch (ConcurrentModificationException exception) {
            assertThat(exception.getMessage(), is("ConcurrentModificationException"));
        }
    }

}