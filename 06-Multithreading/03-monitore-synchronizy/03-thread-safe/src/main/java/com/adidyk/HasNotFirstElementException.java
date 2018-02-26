package com.adidyk;

/**
 * Class HasNotFirstElementException generate exception.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
class HasNotFirstElementException extends RuntimeException {

    /**
     * HasNotFirstElementException - constructor.
     * @param msg - string message.
     */
    HasNotFirstElementException(String  msg) {
        super(msg);
    }

}