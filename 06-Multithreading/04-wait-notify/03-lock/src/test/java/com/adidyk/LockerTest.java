package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class LockerTest does testing of class Locker.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
public class LockerTest {

    /**
     * lockAndUnlockTest - test methods lock and unlock of class Lock.
     * @throws InterruptedException - is interrupted exception.
     */
    @Test
    public void lockAndUnlockTest() throws InterruptedException {
        Locker locker = new Locker();
        Counter counter = new Counter();
        Thread first0 = new Thread(new MyThreadFirst(locker, counter));
        first0.setName("thread-first-0");
        Thread first1 = new Thread(new MyThreadFirst(locker, counter));
        first1.setName("thread-first-1");
        Thread second = new Thread(new MyThreadSecond(locker, counter));
        second.setName("thread-second-0");
        first0.start();
        first1.start();
        second.start();
        Thread.sleep(3000);
        assertThat(3, is(counter.getCounter()));
    }

}