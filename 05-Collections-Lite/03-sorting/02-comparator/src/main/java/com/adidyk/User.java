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