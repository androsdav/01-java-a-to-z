package com.adidyk.models;

public class Item {

    public String name;
    public String description;
    public long create;
    private String id;
    public String[] comment =new String[1];
    private int position = 0;

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

    public String addComment(String comment) {
        if (this.position == this.comment.length)
        {
            String[] commentTemp = new String[2 * this.comment.length];
            System.arraycopy(this.comment, 0, commentTemp, 0, this.comment.length);
            this.comment = commentTemp;
        }
        this.comment[this.position++] = comment;
        return comment;
    }

    public String[] getAllComment() {
        String[] result = new String[this.position];
        System.arraycopy(this.comment, 0, result, 0, this.position);
        return result;
    }

}
