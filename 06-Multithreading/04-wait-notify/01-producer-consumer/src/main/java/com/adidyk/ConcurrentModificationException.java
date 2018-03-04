package com.adidyk;

/**
 * Class ConcurrentModificationException generate exception.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
class ConcurrentModificationException extends RuntimeException {

    /**
     * ConcurrentModificationException - constructor.
     * @param msg - string message.
     */
    ConcurrentModificationException(String msg) {
        super(msg);
    }

}