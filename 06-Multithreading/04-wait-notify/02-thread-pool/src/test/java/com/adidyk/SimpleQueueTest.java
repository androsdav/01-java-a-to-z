package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleQueueTest does testing method of class SimpleQueue.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
public class SimpleQueueTest {

    /**
     * @param queue - is reference variable to object of class SimpleQueue.
     */
    private SimpleQueue<Work> queue = new SimpleQueue<>();

    /**
     * @param work1 - is link variable to object of class Work.
     */
    private Work work1 = new Work(1, "work1");

    /**
     * @param work2 - is link variable to object of class Work.
     */
    private Work work2 = new Work(2, "work2");

    /**
     * @param work3 - is link variable to object of class Work.
     */
    private Work work3 = new Work(3, "work3");

    /**
     * @param work4 - is link variable to object of class Work.
     */
    private Work work4 = new Work(4, "work4");

    /**
     * @param it - iterator.
     */
    private Iterator it;

    /**
     * init - initialisation all parameters and adds new work to container queue.
     */
    @Before
    public void init() {
        this.queue.push(new Work(1, "work1"));
        this.queue.push(new Work(2, "work2"));
        this.queue.push(new Work(3, "work3"));
        this.queue.push(new Work(4, "work4"));
        this.it = queue.iterator();
    }

    /**
     * emptyTrueTest - tests method empty of class SimpleQueue when queue is empty.
     */
    @Test
    public void emptyTrueTest() {
        SimpleQueue<Work> queue = new SimpleQueue<>();
        assertThat(true, is(queue.empty()));
    }

    /**
     * emptyFalseTest - tests method empty of class SimpleQueue when queue is not empty.
     */
    @Test
    public void emptyFalseTest() {
        SimpleQueue<Work> queue = new SimpleQueue<>();
        final Work result = queue.push(this.work1);
        assertThat(false, is(queue.empty()));
        assertThat(new Work(1, "work1"), is(result));
    }

    /**
     * peekTest - tests method peek of class SimpleQueue.
     */
    @Test
    public void peekTest() {
        assertThat(new Work(1, "work1"), is(this.queue.peek()));
    }

    /**
     * popTest - tests method pop of class SimpleQueue.
     */
    @Test
    public void popTest() {
        assertThat(new Work(1, "work1"), is(this.queue.pop()));
        assertThat(new Work(2, "work2"), is(this.queue.peek()));
    }

    /**
     * searchTrueTest - tests method search of class SimpleQueue when object is in queue.
     */
    @Test
    public void searchTrueTest() {
        assertThat(4, is(this.queue.search(new Work(4, "work4"))));
        assertThat(1, is(this.queue.search(new Work(1, "work1"))));
    }

    /**
     * searchFalseTest - tests method search of class SimpleQueue when object is not in queue.
     */
    @Test
    public void searchFalseTest() {
        assertThat(-1, is(this.queue.search(new Work(5, "work5"))));
    }

    /**
     * sizeTest - tests method size of class SimpleQueue.
     */
    @Test
    public void sizeTest() {
        assertThat(4, is(this.queue.size()));
    }

    /**
     * forEachTest - tests method forEach of class SimpleQueue.
     */
    @Test
    public void forEachTest() {
        Object[] resultActual = new Object[] {this.work1, this.work2, this.work3, this.work4};
        Object[] resultExpected = new Object[4];
        int index = 0;
        for (Work work : this.queue) {
            resultExpected[index++] = work;
        }
        assertThat(resultActual, is(resultExpected));
    }

    /**
     * nextTest - it tests method next for iterator when next element from container is true.
     */
    @Test
    public void nextTest() {
        this.it.next();
        this.it.next();
        assertThat(new Work(3, "work3"), is(this.it.next()));
    }

    /**
     * hasNextTrueTest - it tests method hasNext for iterator when next element from container is true.
     */
    @Test
    public void hasNextTrueTest() {
        this.it.next();
        this.it.next();
        this.it.hasNext();
        assertThat(true, is(this.it.hasNext()));
    }

    /**
     * hasNextFalseTest - it tests method hasNext for iterator when next element from container is false.
     */
    @Test
    public void hasNextFalseTest() {
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.hasNext();
        this.it.hasNext();
        assertThat(false, is(this.it.hasNext()));
    }

    /**
     * loopTest - it test loop for iterator.
     */
    @Test
    public void loopTest() {
        Object[] resultActual = new Object[] {this.work1, this.work2, this.work3, this.work4};
        Object[] resultExpected = new Object[4];
        int index = 0;
        while (this.it.hasNext()) {
            resultExpected[index++] = this.it.next();
        }
        assertThat(resultActual, is(resultExpected));
    }

}