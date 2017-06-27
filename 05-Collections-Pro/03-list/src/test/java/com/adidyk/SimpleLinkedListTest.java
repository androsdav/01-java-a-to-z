package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {

    private SimpleLinkedList<User> listActual = new SimpleLinkedList<>();
    private SimpleLinkedList<User> listExpected = new SimpleLinkedList<>();

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
    }

     @Test
    public void addTest() {
        assertThat(this.listActual, is(this.listExpected));
    }

    @Test
    public void getTest() {
        User result = this.listActual.get(4);
        assertThat(new User("4", "Argon", 14), is(result));
    }

    @Test
    public void getFirstTest() {
        User result = this.listActual.getFirst();
        assertThat(new User("0", "Bob", 10), is(result));
    }

    @Test
    public void getLast() {
        User result = this.listActual.getLast();
        assertThat(new User("7", "Sabrina", 17), is(result));
    }

    @Test
    public void sizeTest() {
        assertThat(8, is(this.listExpected.size()));
    }

    @Test
    public void forEachTest(){
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

    @Test
    public void iteratorTest() {
        new SimpleIteratorTest().nextTest();
        new SimpleIteratorTest().hasNextTrue();
        new SimpleIteratorTest().hasNextFalse();
        new SimpleIteratorTest().loopTest();
    }

    private class SimpleIteratorTest {

        Iterator<User> it = listActual.iterator();

        @Before
        public void init() {
            init();
        }

        @Test
        private void nextTest() {
            this.it.next();
            assertThat(new User("1", "Matilda", 11), is(this.it.next()));
        }

        @Test
        private void hasNextTrue() {
            this.it.next();
            this.it.next();
            this.it.hasNext();
            assertThat(true, is(this.it.hasNext()));
        }

        @Test
        private void hasNextFalse() {
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

        @Test
        private void loopTest() {
            Object[] resultActual = new Object[] {new User("0", "Bob", 10), new User("1", "Matilda", 11),
                    new User("2", "Bill", 12), new User("3", "Donald", 13), new User("4", "Argon", 14),
                    new User("5", "Will", 15), new User("6", "Amanda", 16), new User("7", "Sabrina", 17)};
            Object[] resultExpected = new Object[8];
            int index = 0;
            while(this.it.hasNext()) {
                resultExpected[index++] = this.it.next();
            }
            assertThat(resultActual, is(resultExpected));
        }

    }

}