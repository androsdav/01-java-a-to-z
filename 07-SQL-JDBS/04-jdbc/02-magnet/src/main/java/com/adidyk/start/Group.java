package com.adidyk.start;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 28.09.2018.
 * @version 1.0.
 */
@XmlRootElement
@XmlType(propOrder = {"name"}, name = "group")
public class Group {

    /**
     * @param name - name group.
     */
    private String name;

    /**
     * @param customers - list of customers.
     */
    private List<Customer> customers = new ArrayList<>();

    /**
     * setName - sets name.
     * @param name - name group.
     */
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    /**
     * seCustomers - sets customers.
     * @param customers - customers.
     */
    //@XmlElement
    void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * getName - returns name customer.
     * @return - returns name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getCustomers - gets customers.
     * @return - returns customers.
     */
    List<Customer> getCustomers() {
        return this.customers;
    }

}
