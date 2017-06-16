package com.adidyk;

public class RoleStore<T extends Base> implements Store<T> {

    private SimpleArray<T> list = new SimpleArray<>();

    @Override
    public void add(T object) {
        this.list.add(object);
    }

    @Override
    public void add(int index, T object) {
        this.list.add(index, object);
    }

    @Override
    public void set(int index, T object) {
        this.list.set(index, object);
    }

    @Override
    public void remove(T object) {
        this.list.remove(object);
    }

    @Override
    public void remove(int index) {
        this.list.remove(index);
    }

    @Override
    public T get(int index) {
        return this.list.get(index);
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
