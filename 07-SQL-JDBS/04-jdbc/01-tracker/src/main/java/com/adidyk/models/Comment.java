package com.adidyk.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Class Item for create item (object) with params: id, name, description, create.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class Comment {

    /**
     * @param id - id comment.
     */
    private String id;

    /**
     * @param name - name comment.
     */
    private String name;

    /**
     * @param description - description comment.
     */
    private String description;

    /**
     * @param create - date create comment.
     */
    private long create;

    /**
     * @param dateFormat - date format for date create comment.
     */
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");

    /**
     * Comment - constructor.
     * @param name - name comment.
     * @param description - description comment.
     * @param create - date create comment.
     */
    public Comment(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }


    /**
     * setId - sets id from comment.
     * @param id - id comment.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getId - returns id for comment.
     * @return - returns id for comment.
     */
    public String getId() {
        return this.id;
    }

    /**
     * getName - returns name for comment.
     * @return - returns name for comment.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getDescription - returns description for comment.
     * @return - returns description for comment.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * getCreate - returns date create for comment.
     * @return - returns date create for comment.
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * equals - returns boolean result.
     * @param obj - object of class Item.
     * @return - returns boolean result "true" if create, name, description, id of comment is same,
     * and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Comment comment = (Comment) obj;
        return this.create == comment.create && this.name.equals(comment.name)
                && this.description.equals(comment.description) && this.id.equals(comment.id);
    }

    /**
     * hashCode - returns hashCode for comment.
     * @return - returns hashCode for comment.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (int) (create ^ (create >>> 32));
        result = 31 * result + id.hashCode();
        return result;
    }

    /**
     * toString - returns string format.
     * @return - returns all information for comment.
     */
    @Override
    public String toString() {
        return String.format(" %10s%7s%2s %-18s%2s %-38s%2s %s%2s", "|", this.getId(), "|", this.getName(), "|",
                this.getDescription(), "|", this.dateFormat.format(this.getCreate()), "|");
    }

}