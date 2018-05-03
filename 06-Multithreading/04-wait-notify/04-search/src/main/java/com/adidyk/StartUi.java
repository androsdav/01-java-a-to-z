package com.adidyk;

import java.io.IOException;
import static com.adidyk.Constant.*;

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
     * @throws IOException - is interrupted exception.
     */
    public static void main(String[] arg) throws InterruptedException, IOException {
        Constant.initialization();
        ParallelSearch parallelSearch = new ParallelSearch(ROOT, TEXT, EXTENSIONS);
        parallelSearch.initialization();
        for (String item : parallelSearch.get()) {
            System.out.println(item);
        }
    }
}