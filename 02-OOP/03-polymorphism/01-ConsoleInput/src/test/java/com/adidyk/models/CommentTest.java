package com.adidyk.models;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CommentTest{

    private Comment comment = new Comment("comment1");

    @Test
    public void setCommentTest() {
        this.comment.setComment("comment2");
        String result = this.comment.getComment();
        assertThat(result, is("comment2"));
    }

    @Test
    public void getCommentTest() {
        String result = this.comment.getComment();
        assertThat(result, is("comment1"));
    }

}
