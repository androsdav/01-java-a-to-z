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
public class SimpleLinkedListTest {

    /**
     * @param listActual - is reference variable to object of class SimpleLinkedList.
     */
    private SimpleLinkedList<User> listActual = new SimpleLinkedList<>();

    /**
     * @param listExpected - is reference variable to object of class SimpleLinkedList.
     */
    private SimpleLinkedList<User> listExpected = new SimpleLinkedList<>();

    /**
     * @param it - iterator.
     */
    private Iterator it;

    /**
     * init - initialisation all parameters and adds new user to container list.
     */
    @Before
    public void init() {
        this.listActual.add(new User("0", "Bob", 10));
        this.listActual.add(new User("1", "Matilda", 11));
        this.listActual.add(new User("2", "Bill", 12));
        this.listActual.add(new User("3", "Donald", 13));
        this.listActual.add(new User("4", "Argon", 14));
        this.listActual.add(new User("5", "Will", 15));
        this.listActual.add(new User("6", "Amanda", 16));
        this.listActual.add(new User("7", "Sabrina", 17));
        this.listExpected.add(new User("0", "Bob", 10));
        this.listExpected.add(new User("1", "Matilda", 11));
        this.listExpected.add(new User("2", "Bill", 12));
        this.listExpected.add(new User("3", "Donald", 13));
        this.listExpected.add(new User("4", "Argon", 14));
        this.listExpected.add(new User("5", "Will", 15));
        this.listExpected.add(new User("6", "Amanda", 16));
        this.listExpected.add(new User("7", "Sabrina", 17));
        this.it = listActual.iterator();
    }

    /**
     * addTest - tests method add of class SimpleLinkedList.
     */
    @Test
    public void addTest() {
        assertThat(this.listActual, is(this.listExpected));
    }

    /**
     * getTest - tests method get of class SimpleLinkedList.
     */
    @Test
    public void getTest() {
        User result = this.listActual.get(4);
        assertThat(new User("4", "Argon", 14), is(result));
    }

    /**
     * getFirstTest - tests method getFirst of class SimpleLinkedList.
     */
    @Test
    public void getFirstTest() {
        User result = this.listActual.getFirst();
        assertThat(new User("0", "Bob", 10), is(result));
    }

    /**
     * getLastTest - tests method getLast of class SimpleLinkedList.
     */
    @Test
    public void getLastTest() {
        User result = this.listActual.getLast();
        assertThat(new User("7", "Sabrina", 17), is(result));
    }

    /**
     * sizeTest - tests method size of class SimpleLinkedList.
     */
    @Test
    public void sizeTest() {
        assertThat(8, is(this.listExpected.size()));
    }

    /**
     * forEachTest - tests method forEach of class SimpleLinkedList.
     */
    @Test
    public void forEachTest() {
        Object[] resultActual = new Object[] {new User("0", "Bob", 10), new User("1", "Matilda", 11),
                new User("2", "Bill", 12), new User("3", "Donald", 13), new User("4", "Argon", 14),
                new User("5", "Will", 15), new User("6", "Amanda", 16), new User("7", "Sabrina", 17)};
        Object[] resultExpected = new Object[8];
        int index = 0;
        for (Object user : this.listExpected) {
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
        assertThat(new User("1", "Matilda", 11), is(this.it.next()));
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
        this.it.next();
        this.it.next();
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
        Object[] resultActual = new Object[] {new User("0", "Bob", 10), new User("1", "Matilda", 11),
                new User("2", "Bill", 12), new User("3", "Donald", 13), new User("4", "Argon", 14),
                new User("5", "Will", 15), new User("6", "Amanda", 16), new User("7", "Sabrina", 17)};
        Object[] resultExpected = new Object[8];
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
            this.listActual.add(new User("11", "Anton", 123));
            it.next();
        } catch (ConcurrentModificationException exception) {
            assertThat(exception.getMessage(), is("ConcurrentModificationException"));
        }
    }

}