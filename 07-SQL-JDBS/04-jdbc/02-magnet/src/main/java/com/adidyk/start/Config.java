package com.adidyk.start;

/**
 * Class StoreSQL for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
class Config {

    /**
     * @param url - url to data base magnet
     */
    private String url = "jdbc:sqlite:magnet.sqlite";

    /**
     * setUrl - sets url connect to data base magnet.
     * @param url - url data base magnet.
     */
    void setUrl(String url) {
        this.url = url;
    }

    /**
     * getUrl - returns url data base magnet.
     * @return - returns url data base magnet.
     */
    String getUrl() {
        return this.url;
    }

}