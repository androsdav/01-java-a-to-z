package com.adidyk;

public class UserStore {

    private SimpleArray<User> list = new SimpleArray<>();


    @Override
    public void add(User object) {
        this.list.add(object);
    }

    @Override
    public void add(int index, Base object) {

    }

    @Override
    public void set(int index, Base object) {

    }

    @Override
    public void remove(Base object) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public Base get(int index) {
        return null;
    }

    @Override
    public Object[] getAll() {
        return new Object[0];
    }

    @Override
    public int size() {
        return 0;
    }
}