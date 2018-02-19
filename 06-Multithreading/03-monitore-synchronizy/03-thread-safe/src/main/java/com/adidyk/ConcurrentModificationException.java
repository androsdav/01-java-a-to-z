package com.adidyk;

/**
 * Class ConcurrentModificationException generate exception.
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