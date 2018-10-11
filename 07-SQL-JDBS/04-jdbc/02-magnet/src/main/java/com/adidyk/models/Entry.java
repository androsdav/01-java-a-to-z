package com.adidyk.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Class StoreSQL for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
@XmlRootElement(name = "entries")
public class Entry {

    /**
     * @param list - link variable to object of class List (generic is class Field).
     */
    private List<Field> list;

    /**
     * setList - sets list.
     * @param list - is entries.
     */
    @XmlElement(name = "entry")
    public void setList(List<Field> list) {
        this.list = list;
    }

    /**
     * getList - returns list.
     * @return - returns list.
     */
    public List<Field> getList() {
        return this.list;
    }

}