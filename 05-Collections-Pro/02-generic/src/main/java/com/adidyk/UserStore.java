package com.adidyk;

public class UserStore<T extends Base> implements Store<T> {

    private SimpleArray<T> list;
//    public User user = new User();

    public UserStore() {
        this.list = new SimpleArray<>();
    }

    @Override
    public void add(T object) {
        list.add(object);
    }

    public Object[] getAll() {
        return this.list.getAll();
    }
}
