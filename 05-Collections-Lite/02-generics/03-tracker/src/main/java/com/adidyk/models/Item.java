package com.adidyk.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Item {

    private String name;
    private String description;
    private long create;
    private String id;
    private ArrayList<Comment> comment = new ArrayList<>();
    private DateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yy HH:mm");

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
        this.comment.add(comment);
        return comment;
    }

    public ArrayList<Comment> getAllComment() {
        return this.comment;
    }

    @Override
    public String toString() {
        return (" - [name]: " + getName() + " [desc]: " + getDescription() + " [create]: " + this.dateFormat1.format(getCreate()) + " [id]: " + getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (create != item.create) return false;
        if (!name.equals(item.name)) return false;
        if (!description.equals(item.description)) return false;
        return id.equals(item.id);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (int) (create ^ (create >>> 32));
        result = 31 * result + id.hashCode();
        return result;
    }

}