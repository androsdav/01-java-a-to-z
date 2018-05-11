package com.adidyk;

/**
 * Class HasNotFirstElementException generate exception.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 13.03.2018.
 * @version 1.0.
 */
class OptimisticException extends RuntimeException {

    /**
     * HasNotFirstElementException - constructor.
     * @param msg - string message.
     */
    OptimisticException(String  msg) {
        super(msg);
    }

}
