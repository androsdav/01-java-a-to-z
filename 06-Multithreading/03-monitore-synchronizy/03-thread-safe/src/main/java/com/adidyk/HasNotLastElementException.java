package com.adidyk;

/**
 * Class HasNotLastElementException generate exception.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
class HasNotLastElementException extends RuntimeException {

    /**
     * HasNotLastElementException - constructor.
     * @param msg - string message.
     */
    HasNotLastElementException(String msg) {
        super(msg);
    }

}