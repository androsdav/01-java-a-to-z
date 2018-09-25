package com.adidyk.models;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ItemTest for testing methods class "Item".
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 25.09.2018.
 * @version 1.0.
 */
public class ItemTest {

    /**
     * @param itemActual - link variable to object of class Item.
     */
    private final Item itemActual = new Item("Work", "I search work", 100);

    /**
     * init - method is run before each test.
     */
    @Before
    public void init() {
        this.itemActual.setId("1");
    }

    /**
     * itemTest - tests object item.
     */
    @Test
    public void itemTest() {
        Item itemExpected = new Item("Work", "I search work", 100);
        itemExpected.setId("1");
        assertThat(this.itemActual, is(itemExpected));
    }

    /**
     * setIdTest - tests method setId of class Item.
     */
    @Test
    public void setIdTest() {
        this.itemActual.setId("2");
        assertThat(this.itemActual.getId(), is("2"));
    }

    /**
     * getNameTest - tests method getName of class Item.
     */
    @Test
    public void getNameTest() {
        assertThat(this.itemActual.getName(), is("Work"));
    }

    /**
     * getDescriptionTest - tests method getDescription of class Item.
     */
    @Test
    public void getDescriptionTest() {
        assertThat(this.itemActual.getDescription(), is("I search work"));
    }

    /**
     * getCreateTest - tests method getCreate of class Item.
     */
    @Test
    public void getCreateTest() {
        assertThat(this.itemActual.getCreate(), is(100L));
    }

}