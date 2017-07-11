package com.adidyk;

public class User implements Comparable<User> {

    private String id;
    private String name;
    private int age;

    User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (age != user.age) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return String.format( "%s%s%s%s%s%s%s%s%s%s",
                " User {", "id=", this.getId(), "; name=", this.getName(), "; age=", this.getAge(), "}",
                " hashCode: ", hashCode());
    }

    @Override
    public int compareTo(User user) {
        return Integer.valueOf(this.hashCode()).compareTo(user.hashCode());
    }

}