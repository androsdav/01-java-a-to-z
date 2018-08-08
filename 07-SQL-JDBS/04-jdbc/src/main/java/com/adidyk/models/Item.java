package com.adidyk.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Class StartUi for create jar file and connect to data base..
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class Item {

    /**
     *
     */
    private String id;


    /**
     *
     */
    private String name;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private long create;


    //private Comment[] comment = new Comment[10];

    /**
     *
     */
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");

    /**
     *
     * @param name - is name.
     * @param description - is description.
     * @param create - is create.
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     *
     * @param name - is name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param description - is.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param create - is.
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     *
     * @param id - is.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return string.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @return long.
     */
    public long getCreate() {
        return this.create;
    }

    /**
     *
     * @return string.
     */
    public String getId() {
        return this.id;
    }

    /**
     *
     * @return string.
     */
    public String getName() {
        return this.name;
    }

    /*
    public Comment addComment(Comment comment) {
        for (int index = 0; index < this.comment.length; index++) {
            if (this.comment[index] == null) {
                this.comment[index] = comment;
                break;
            }
        }
        int length = 0;
        for (Comment comm : this.comment) {
            if (comm != null) {
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
    */
    /*
    public Comment[] getAllComment() {
        return this.comment;
    }
    */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return this.create == item.create && this.name.equals(item.name) && this.description.equals(item.description) && this.id.equals(item.id);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (int) (create ^ (create >>> 32));
        result = 31 * result + id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return (" - [name]: " + getName() + " [desc]: " + getDescription() + " [create]: " + this.dateFormat.format(this.getCreate()) + " [id]: " + this.getId());
    }

}