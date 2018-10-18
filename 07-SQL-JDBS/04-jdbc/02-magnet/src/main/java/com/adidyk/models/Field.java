package com.adidyk.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class Field for create field (object) with param field.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.10.2018.
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
     * @param field - field.
     */
    @XmlElement(name = "field")
    public void setField(int field) {
        this.field = field;
    }

    /**
     * getField - returns field.
     * @return - returns field.
     */
    private int getField() {
        return this.field;
    }

}