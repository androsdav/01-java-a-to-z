package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<User> list = new SimpleArrayList<>();
    private User tom;
    private User bill;
    private User bob;

    @Before
    public void init() {
        this.tom = new User("1", "Tom", 17);
        this.bill = new User("2", "Bill", 18);
        this.bob = new User("3", "Bob", 20);
        this.list.add(new User("1", "Tom", 17));
        this.list.add(new User("2", "Bill", 18));
        this.list.add(new User("3", "Bob", 20));
    }

    @Test
    public void addTest() {
        Object[] objects = new Object[] {this.tom, this.bill, this.bob};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void getTest() {
        assertThat(new User("3", "Bob", 20), is(this.list.get(2)));
    }

    @Test
    public void getAllTest() {
        User evan = new User("6", "Evan", 33);
        this.list.add(new User("6", "Evan", 33));
        Object[] objects = new Object[] {this.tom, this.bill, this.bob, evan};
        assertThat(objects, is(this.list.getAll()));
    }

    @Test
    public void sizeTest() {
        assertThat(3, is(this.list.size()));
    }

    @Test
    public void forEachTest() {
        Object[] resultActual = new Object[] {new User("1", "Tom", 17), new User("2", "Bill", 18), new User("3", "Bob", 20)};
        Object[] resultExpected = new Object[3];
        int index = 0;
        for (Object user : this.list.getAll()) {
            resultExpected[index++] = user;
        }
        assertThat(resultActual, is(resultExpected));

    }

    @Test
    public void iteratorTest() {
        new NewIteratorTest().nextTest();
        new NewIteratorTest().hasNextTrue();
        new NewIteratorTest().hasNextFalse();
        new NewIteratorTest().loopTest();
    }

    private class NewIteratorTest {

        Iterator<User> it = list.iterator();

        @Before
        public void init() {
            init();
        }

        @Test
        private void nextTest() {
            this.it.next();
            assertThat(new User("2", "Bill", 18), is(this.it.next()));
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
            this.it.hasNext();
            assertThat(false, is(this.it.hasNext()));
        }

        @Test
        private void loopTest() {
            Object[] resultActual = new Object[] { new User("1", "Tom", 17),new User("2", "Bill", 18), new User("3", "Bob", 20)};
            Object[] resultExpected = new Object[3];
            int index = 0;
            while(this.it.hasNext()) {
                resultExpected[index++] = this.it.next();
            }
            assertThat(resultActual, is(resultExpected));
        }

    }

}