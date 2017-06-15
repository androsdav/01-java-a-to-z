package com.adidyk;

public class UserStore extends Base implements Store {

    private SimpleArray<T> array;
    public User user = new User();

    public UserStore() {
        this.array = new SimpleArray<>();
    }

    public void add(T object) {
        array.add(object);
    }

    @Override
    public void add() {

    }
}
