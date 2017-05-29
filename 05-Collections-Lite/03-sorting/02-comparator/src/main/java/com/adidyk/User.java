package com.adidyk;

public class User implements Comparable<User> {

    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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
        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s%13s%s%3s%s%s",
                " Name: ", this.getName(), "  age: ", this.getAge(), " hashCode: ", hashCode());
    }

    @Override
    public int compareTo(User user) {
        if (this.age > user.getAge())
            return 1;
        else if (this.age < user.getAge())
            return -1;
        else
            return 0;
        }

}