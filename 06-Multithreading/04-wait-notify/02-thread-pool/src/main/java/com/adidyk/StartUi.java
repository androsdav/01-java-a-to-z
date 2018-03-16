package com.adidyk;

/** Class StartUi for create jar file and run program (Producer-Consumer).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - run program, create Producer-Thread and Consumer-Thread.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        int core = Runtime.getRuntime().availableProcessors();
        //System.out.println(core);
        ThreadPool pool = new ThreadPool(3);
        for (int index = 0; index < 20; index++) {
            pool.add("work-" + index);
        }
        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        pool.finish();

//        pool.threadInterapted();
        }

}