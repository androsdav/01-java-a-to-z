package com.adidyk;

/**
 * Class StartUi for create jar file and run program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 03.01.2017.
 * @version 1.0.
 */
public class AsynchronousOperation {

    /**
     * Class Calculate is calculate.
     */
    public static final class Calculate implements Runnable {

        /**
         * @param name - is name thread.
         */
        private final String name;

        /**
         * Calculate - constructor.
         * @param name is name.
         */
        Calculate(final String name) {
            this.name = name;
        }

        /**
         * run - is run.
         */
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s asynchronous", this.name));
        }
    }


    /**
     * main - is for create jar file and run program.
     * @param arg is nothing.
     */
    public static void main(String[] arg) {
        String string = " dasd asd asd as asd  sd 11111 1 11111111 1 1 12    ";
        new Thread(new CounterSpace("thread 1", string)).start();
        new Thread(new CounterWord("thread 2", string)).start();
       /*
        new Thread(() -> {
            System.out.println("start");
            new Thread(new Calculate("thread 1")).start();
            new Thread(new Calculate("thread 2")).start();
            new Thread(() -> System.out.println("Tread anon asynchronous")).start();
            System.out.println("finish");
        }).start();
        */



//        System.out.println("start");
  //      new Thread(new Calculate("thread 1")).start();
    //    new Thread(new Calculate("thread 2")).start();
      //  new Thread() {
        //    @Override
        //    public void run() {
        //        System.out.println("Tread anon asynchronous");
        //    }
        //}.start();
        //System.out.println("finish");
        /*
        System.out.println("Thread:");
        Thread thread = new Thread();
        System.out.println("1. Name: " + thread.getName());
        thread.setName("test-thread");
        System.out.println("2. Name: " + thread.getName());
        System.out.println("3. Priority: " + thread.getPriority());
        thread.setPriority(10);
        System.out.println("4. Priority: " + thread.getPriority());
        thread.start();
        System.out.println("5. Active: " + thread.isAlive());
        System.out.println("5. Daemon: " + thread.isDaemon());
        System.out.println("All information thread:" + thread);
        */
    }

}
