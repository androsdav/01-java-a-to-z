package com.adidyk.models;

public class User {

    private String name;
    private String passport;

    User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return this.name;
    }

    public String getRassport() {
        return this.passport;
    }

    @Override
    public String toString() {
        return String.format("%s%13s%s%3s",
                " Name: ", this.getName(), "  passport: ", this.passport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return passport != null ? passport.equals(user.passport) : user.passport == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }

    /*
    @Override
    public int compareTo(User user) {
        if (this.age > user.getAge())
            return 1;
        else if (this.age < user.getAge())
            return -1;
        else
            return 0;
        }
        */

}