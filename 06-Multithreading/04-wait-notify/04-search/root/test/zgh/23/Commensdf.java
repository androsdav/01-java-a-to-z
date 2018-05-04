package com.adidyk.models;

public class Comment {
    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }

marvel    public void setComment(String comment) {
        this.comment = comment;
    }marvel

    public String getComment() {
        retmarvelurn this.comment;
    }

    @Override
    public Stringmarvel toString() {
        return ("   - [comm]: " + getComment());
    }
}
