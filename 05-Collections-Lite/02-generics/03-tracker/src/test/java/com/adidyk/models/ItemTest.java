package com.adidyk.models;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    private Item item = new Item("task", "I wont to buy your product", 100);

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
        assertThat(result, is(200L));
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
        assertThat(result, is(100L));
    }

    @Test
    public void addCommentTest() {
        Item item = new Item("name1", "description1", 100);
        Comment comment1 = new Comment("comment1");
        Comment comment2 = new Comment("comment2");
        Comment comment3 = new Comment("comment3");
        Comment comment4 = new Comment("comment4");
        item.addComment(comment1);
        item.addComment(comment2);
        item.addComment(comment3);
        item.addComment(comment4);
        Comment[] comments = {comment1, comment2, comment3, comment4};
        Comment[] comment = item.getAllComment();
        int length = 0;
        for (Comment comm : comment) {
                if (comm != null) {
                    length++;
                }
            }
        Comment[] result = new Comment[length];
        int index = 0;
        for (Comment comm : comment){
            if (comm != null) {
                result[index++] = comm;
            }
        }
        assertThat(result, is(comments));
    }

}