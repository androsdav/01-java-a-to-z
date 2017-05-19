package com.adidyk;

import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User guest = (User) obj;
        return Objects.equals(id, guest.id)
                && (Objects.equals(name, guest.name)
                || (name != null && name.equals(guest.getName()))) && (Objects.equals(city, guest.city)
                || (city != null && city.equals(guest.getCity())
        ));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id; result = prime * result + ((city == null) ? 0 : city.hashCode()); return result;
    }

}
