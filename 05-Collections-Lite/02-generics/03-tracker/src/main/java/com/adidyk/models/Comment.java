package com.adidyk.models;

public class Comment {
    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

    @Override
    public String toString() {
        return ("   - [comm]: " + getComment());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        return comment.equals(comment1.comment);
    }

    @Override
    public int hashCode() {
        return comment.hashCode();
    }

}
