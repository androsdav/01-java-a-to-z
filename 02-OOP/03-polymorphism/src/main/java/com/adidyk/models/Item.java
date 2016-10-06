package com.adidyk.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Item {

    private String name;
    private String description;
    private long create;
    private String id;
    private Comment[] comment = new Comment[1];

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
        int length = 0;
        for (int index = 0; index < this.comment.length; index++) {
            if(this.comment[index] != null) {
                length++;
            }
        }
        if (length == this.comment.length) {
            Comment[] commentTemp = new Comment[2 * this.comment.length];
            System.arraycopy(this.comment, 0, commentTemp, 0, this.comment.length);
            this.comment = commentTemp;
        }
        return comment;
    }

    public Comment[] getAllComment() {
        return this.comment;
    }

    public String toString(Item item) {
        DateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yy HH:mm");
        return (" - [name]: " + item.getName() + " [desc]:  " + item.getDescription() + " [create]: " + dateFormat1.format(item.getCreate()) + " [id]: " + item.getId());
    }
}
