package com.adidyk.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Class Entry for create entry (object) with param: list all fields.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.10.2018.
 * @version 1.0.
 */
@XmlRootElement(name = "entries")
@XmlType(propOrder = {"list"})
public class Entry {

    /**
     * @param list - link variable to object of class List (list all fields).
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
    private List<Field> getList() {
        return this.list;
    }

}