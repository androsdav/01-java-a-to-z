package com.adidyk;

/** Class StartUi for create jar file and run program (Locker).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.04.2018.
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
        Counter counter = new Counter();
        counter.addCounter();
        counter.addCounter();
        counter.addCounter();
        System.out.println();
        System.out.println(" result: " + counter.getCounter());
    }

}