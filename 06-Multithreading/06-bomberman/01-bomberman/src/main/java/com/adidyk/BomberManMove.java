package com.adidyk;

/**
 * Class StartUi for create jar file and run program (Parallel Search).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 11.06.2018.
 * @version 1.0.
 */
public class BomberManMove implements Runnable {

    /**
     * @param bomber - is bomber.
     */
    private final BomberMan bomber;

    /**
     *
     * @param bomber - is bomber.
     */
    public BomberManMove(BomberMan bomber) {
        this.bomber = bomber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.bomber.moveUp();
    }
}
