package com.adidyk;

/** Class StartUi for create jar file and run program (Locker).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program, creates three thread: one thread of class MyThreadFirst and two thread
     * of class MyThreadSecond.
     * @param arg - is nothing.
     * @throws InterruptedException - is interrupted exception.
     */
    public static void main(String[] arg) throws InterruptedException {
        System.out.println();
        System.out.println(" Locker ...");
        System.out.println();
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
        System.out.println();
        System.out.println(" result: " + counter.getCounter());
    }

}