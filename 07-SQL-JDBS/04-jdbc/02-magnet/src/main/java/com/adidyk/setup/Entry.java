package com.adidyk.setup;

import com.adidyk.start.Field;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Class StoreSQL for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
@XmlRootElement
@XmlType(propOrder = {"entries"})
public class Entry {

    /**
     *
     */
    private List<Field> entries;

    /**
     *
     * @param entries - is entries.
     */
    @XmlElement
    public void setEntries(List<Field> entries) {
        this.entries = entries;
    }

    /**
     *
     * @return entries.
     */
    public List<Field> getEntries() {
        return this.entries;
    }

}