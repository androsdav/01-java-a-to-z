package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetLinkedListTest {

    private SimpleSetLinkedList<User> set = new SimpleSetLinkedList<>();

    @Before
    public void init() {
        this.set.add(new User("0","Bob",10));
        this.set.add(new User("2","Bill",11));
        this.set.add(new User("3","Will",12));
        this.set.add(new User("4","Zeal",13));
    }

    @Test
    public void addTestTrue() {
        boolean addTrue = this.set.add(new User("5", "Dilan", 14));
        assertThat(true, is(addTrue));
    }

    @Test
    public void addTestFalse(){
        boolean addFalse = this.set.add(new User("3", "Will", 12));
        assertThat(false, is(addFalse));
    }

    @Test
    public void sizeTest() {
        assertThat(4, is(this.set.size()));
    }

    @Test
    public void forEachTest() {
        Object[] objectActual = new Object[] {
                new User("0","Bob",10), new User("2","Bill",11),
                new User("3","Will",12), new User("4","Zeal",13)};
        Object[] objectExpected = new Object[4];
        int index = 0;
        for(User user : this.set) {
            objectExpected[index++] = user;
        }
        assertThat(objectActual, is(objectExpected));
    }

    @Test
    public void iteratorTest() {
        new SimpleIteratorTest().nextTest();
        new SimpleIteratorTest().hasNextTrueTest();
        new SimpleIteratorTest().hasNextFalseTest();
        new SimpleIteratorTest().loopTest();
    }

    private class SimpleIteratorTest {

        private Iterator<User> it = set.iterator();

        @Test
        private void nextTest() {
            this.it.next();
            this.it.next();
            assertThat(new User("3", "Will", 12), is(this.it.next()));
        }

        @Test
        private void hasNextTrueTest() {
            this.it.next();
            this.it.next();
            this.it.next();
            this.it.hasNext();
            assertThat(true, is(this.it.hasNext()));
        }

        @Test
        private void hasNextFalseTest() {
            this.it.next();
            this.it.next();
            this.it.next();
            this.it.next();
            this.it.hasNext();
            assertThat(false, is(this.it.hasNext()));
        }

        @Test
        private void loopTest() {
            Object[] objectActual = new Object[] {
                    new User("0","Bob",10), new User("2","Bill",11),
                    new User("3","Will",12), new User("4","Zeal",13)};
            Object[] objectExpected = new Object[4];
            int index = 0;
            while(this.it.hasNext()) {
                objectExpected[index++] = this.it.next();
            }
            assertThat(objectActual, is(objectExpected));
        }

    }

}