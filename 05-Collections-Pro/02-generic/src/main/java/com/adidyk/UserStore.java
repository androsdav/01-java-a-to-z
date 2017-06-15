package com.adidyk;

public class UserStore<T extends Base> implements Store<T> {

    private SimpleArray<T> array;
    public User user = new User();

    public UserStore() {
        this.array = new SimpleArray<>();
    }

    public void add(T object) {
        array.add(object);
    }

    @Override
    public void setId(String id) {
    }

    @Override
    public String getId() {
        return null;
    }
}
