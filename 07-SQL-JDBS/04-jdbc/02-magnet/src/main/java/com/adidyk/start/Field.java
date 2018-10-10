package com.adidyk.start;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class StoreSQL for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
@XmlRootElement
class Field {

    /**
     * @param field - field.
     */
    private int field;

    Field(int field) {
        this.field = field;
    }

    /**
     *
     * @param field - is field.
     */
    public void setField(int field) {
        this.field = field;
    }

    /**
     *
     * @return field.
     */
    public int getField() {
        return this.field;
    }

}
