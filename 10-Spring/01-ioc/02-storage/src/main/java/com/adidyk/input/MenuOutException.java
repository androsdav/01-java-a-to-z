package com.adidyk.input;

/**
 * Class MenuOutException outputs menu out exception.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
class MenuOutException extends RuntimeException {

    /**
     * MenuOutException - constructor.
     * @param msg - message menu out exception.
     */
    MenuOutException(String msg) {
        super(msg);
    }

}