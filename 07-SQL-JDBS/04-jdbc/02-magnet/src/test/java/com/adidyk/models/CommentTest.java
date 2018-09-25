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
public class CommentTest {

    /**
     * @param itemActual - link variable to object of class Item.
     */
    private final Comment commentActual = new Comment("Work", "I search work", 100);

    /**
     * init - method is run before each test.
     */
    @Before
    public void init() {
        this.commentActual.setId("1");
    }
    /**
     * itemTest - tests object item.
     */
    @Test
    public void itemTest() {
        Comment commentExpected = new Comment("Work", "I search work", 100);
        commentExpected.setId("1");
        assertThat(this.commentActual, is(commentExpected));
    }

    /**
     * setIdTest - tests method setId of class Item.
     */
    @Test
    public void setIdTest() {
        this.commentActual.setId("2");
        assertThat(this.commentActual.getId(), is("2"));
    }

    /**
     * getNameTest - tests method getName of class Item.
     */
    @Test
    public void getNameTest() {
        assertThat(this.commentActual.getName(), is("Work"));
    }

    /**
     * getDescriptionTest - tests method getDescription of class Item.
     */
    @Test
    public void getDescriptionTest() {
        assertThat(this.commentActual.getDescription(), is("I search work"));
    }

    /**
     * getCreateTest - tests method getCreate of class Item.
     */
    @Test
    public void getCreateTest() {
        assertThat(this.commentActual.getCreate(), is(100L));
    }

}