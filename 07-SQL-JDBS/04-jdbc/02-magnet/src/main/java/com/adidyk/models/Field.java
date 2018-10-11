package com.adidyk.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class StoreSQL for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
@XmlRootElement(name = "fields")
@XmlType(propOrder = {"field"})
public class Field {

    /**
     * @param field - field.
     */
    private int field;

    /**
     * setField - sets field.
     * @param field - is field.
     */
    @XmlElement(name = "field")
    public void setField(int field) {
        this.field = field;
    }

    /**
     * getField - returns field.
     * @return - returns field.
     */
    public int getField() {
        return this.field;
    }

}