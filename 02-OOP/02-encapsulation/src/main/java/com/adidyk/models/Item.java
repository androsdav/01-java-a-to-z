package com.adidyk.models;

public class Item {

    private String name;
    private String description;
    private long create;
    private String id;
    private Comment[] comment = new Comment[10];

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Comment addComment(Comment comment) {
        for (int index = 0; index < this.comment.length; index++) {
            if (this.comment[index] == null) {
                this.comment[index] = comment;
                break;
            }
        }
        return comment;
    }

    public Comment[] getAllComment() {
        return this.comment;
    }

}
