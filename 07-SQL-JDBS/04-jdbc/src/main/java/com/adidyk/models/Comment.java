package com.adidyk.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Comment {

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
    public Comment(String name, String description, long create) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Comment comment = (Comment) obj;
        return this.create == comment.create && this.name.equals(comment.name) && this.description.equals(comment.description) && this.id.equals(comment.id);
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
        return String.format(" %10s%7s%2s %-18s%2s %-38s%2s %s%2s", "|", this.getId(), "|", this.getName(), "|", this.getDescription(), "|", this.dateFormat.format(this.getCreate()), "|");
    }
}
