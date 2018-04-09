package com.adidyk;

/** Class StartUi for create jar file and run program (Thread-Pool).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.03.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * main - runs program, creates Thread-Pool by number core of processor and adds work to queue,
     * after this completes work.
     * @param arg - is nothing.
     * @throws InterruptedException -is.
     */
    public static void main(String[] arg) throws InterruptedException {
        System.out.println(" Lock ...");
        System.out.println();
        Locker locker = new Locker();
        Counter counter = new Counter();
        Thread first0 = new Thread(new MyThreadFirst(locker, counter));
        first0.setName("thread-first-0");
        Thread first1 = new Thread(new MyThreadFirst(locker, counter));
        first1.setName("thread-first-1");
        //Thread second = new Thread(new MyThreadSecond(locker, counter));
        //second.setName("thread-second-0");
        // test
        //lock.lock();
        first0.start();
        first1.start();
        //second.start();
        Thread.sleep(3000);
        System.out.println();
        System.out.println(" result: " + counter.getCounter());
        //lock.unlock();
        //lock.unlock();
        //second.start();
        //lock.unlock();
//        second.start();


        //Lock lock = new ReentrantLock();

        /*
        public class Lock {

            boolean isLocked = false;
            Thread  lockedBy = null;
            int     lockedCount = 0;

            public synchronized void lock() throws InterruptedException{
                Thread callingThread = Thread.currentThread();
                while(isLocked && lockedBy != callingThread){
                    wait();
                }
                isLocked = true;
                lockedCount++;
                lockedBy = callingThread;
            }


            public synchronized void unlock(){
                if(Thread.curentThread() == this.lockedBy) {
                    lockedCount--;

                    if(lockedCount == 0){
                        isLocked = false;
                        notify();
                    }
                }
            }
        }
        */

    }

}