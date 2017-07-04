package com.adidyk;

import java.util.Iterator;

public class SimpleSetArray<E> implements SimpleSet<E> {

    private Object[] objects;
    private int index = 0;

    SimpleSetArray() {
        this.objects = new Object[0];
    }

    // add -
    public boolean add(E object) {
        boolean addObject = !this.searchDuplicate(object);
        if (addObject) {
            Object[] objectsTemp = new Object[this.objects.length];
            System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
            this.objects = objectsTemp;
            this.objects[this.index] = object;
            this.index++;
        }
        return addObject;
    }

    // searchDuplicate -
    private boolean searchDuplicate(E object) {
        boolean sameObject = false;
        for (int position = 0; position < this.index - 1; position++) {
            if(object.equals(this.objects[position])) {
                sameObject = true;
                break;
            }
        }
        return sameObject;
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
