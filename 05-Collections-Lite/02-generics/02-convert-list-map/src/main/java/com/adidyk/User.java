package com.adidyk;

public class User {

    private Integer id;
    private String name;
    private String city;

    User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!getName().equals(user.getName())) return false;
        return getCity().equals(user.getCity());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCity().hashCode();
        return result;
    }

}