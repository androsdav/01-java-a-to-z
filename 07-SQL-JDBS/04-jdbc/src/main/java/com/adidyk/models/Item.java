package com.adidyk.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Class Item for create item (object) with params: id, name, description, create.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
public class Item {

    /**
     * @param id - id item.
     */
    private String id;


    /**
     * @param name - name item.
     */
    private String name;

    /**
     * @param description - description item.
     */
    private String description;

    /**
     * @param create - date create item.
     */
    private long create;

    /**
     * @param dateFormat - date format for date create item.
     */
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");

    /**
     * Item - constructor.
     * @param name - name item.
     * @param description - description item.
     * @param create - date create item.
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * setId - sets id for item.
     * @param id - is.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getId - returns id for item.
     * @return - returns id for item.
     */
    public String getId() {
        return this.id;
    }

    /**
     * getName - returns name for item.
     * @return - returns name for item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getDescription - returns description for item.
     * @return - returns description for item.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * getCreate - returns date create for item.
     * @return - returns date create for item.
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * equals - returns boolean result.
     * @param obj - object of class Item.
     * @return - returns boolean result "true" if create, name, description, id of item is same,
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
        Item item = (Item) obj;
        return this.create == item.create && this.name.equals(item.name) && this.description.equals(item.description)
                && this.id.equals(item.id);
    }

    /**
     * hashCode - returns hashCode for item.
     * @return - returns hashCode for item.
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
     * @return - returns all information for item.
     */
    @Override
    public String toString() {
        return String.format(" %s%7s%2s %-18s%2s %-47s%2s %s%2s", "|", this.getId(), "|", this.getName(), "|",
                this.getDescription(), "|", this.dateFormat.format(this.getCreate()), "|");
    }

}