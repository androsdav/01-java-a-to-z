package com.adidyk.models;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    Item item = new Item("task", "I wont to buy your product", 100);

    @Test
    public void setNameTest() {
        this.item.setName("bag");
        String result = this.item.getName();
        assertThat(result, is("bag"));
    }

    @Test
    public void setDescriptionTest() {
        this.item.setDescription("Your product doesn't work");
        String result = this.item.getDescription();
        assertThat(result, is("Your product doesn't work"));
    }

    @Test
    public void setCreateTest() {
        this.item.setCreate(200);
        long result = this.item.getCreate();
        assertThat(result, is(200l));
    }
    
    @Test
    public void setIdTest() {
    	this.item.setId("1050");
    	String result = this.item.getId();
    	assertThat(result, is("1050"));
    }

    @Test
    public void getNameTest() {
        String result = this.item.getName();
        assertThat(result, is("task"));
    }

    @Test
    public void getDescriptionTest() {
        String result = this.item.getDescription();
        assertThat(result, is("I wont to buy your product"));
    }

    @Test
    public void getCreateTest() {
        long result = this.item.getCreate();
        assertThat(result, is(100l));
    }
    
}