package com.adidyk;

public class RoleStore<T extends Base> implements Store<T> {

    private SimpleArray<T> list = new SimpleArray<>();

    @Override
    public void add(T object) {
        this.list.add(object);
    }

    @Override
    public void set(T oldObject, T newObject) {
        this.list.set(oldObject, newObject);
    }

    @Override
    public void remove(T object) {
        this.list.remove(object);
    }


    @Override
    public Object[] getAll() {
        return this.list.getAll();
    }

    @Override
    public int size() {
        return this.list.size();
    }

}
