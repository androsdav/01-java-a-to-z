package com.adidyk.start;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 28.09.2018.
 * @version 1.0.
 */
@XmlType(propOrder = {"id", "name", "age"})
public class Customer {

    /**
     * @param name - name.
     */
    private String name;

    /**
     * @param age - age customer.
     */
    private int age;

    /**
     * @param id - id customer.
     */
    private int id;

    /**
     * setName - set name customer.
     * @param name - name customer.
     */
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setAge - sets age customer.
     * @param age - age customer.
     */
    @XmlElement
    void setAge(int age) {
        this.age = age;
    }

    /**
     * setid - sets id customer.
     * @param id - id customer.
     */
    @XmlElement
    void setId(int id) {
        this.id = id;
    }

    /**
     * getName - returns name customer.
     * @return - returns name customer.
     */
    public String getName() {
        return name;
    }


    /**
     * getAge - returns age customer.
     * @return - returns age customer.
     */
    public int getAge() {
        return age;
    }

    /**
     * getId - returns id customer.
     * @return - returns id customer.
     */
    public int getId() {
        return id;
    }

}