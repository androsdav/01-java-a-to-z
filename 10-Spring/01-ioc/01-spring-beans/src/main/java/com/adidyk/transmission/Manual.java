package com.adidyk.transmission;

/**
 * Class Manual defines next method for container of users: showTransmission.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class Manual implements Transmission {

    /**
     * showTransmission - show transmission.
     */
    @Override
    public void showTransmission() {
        System.out.println("transmission-manual");
    }

}