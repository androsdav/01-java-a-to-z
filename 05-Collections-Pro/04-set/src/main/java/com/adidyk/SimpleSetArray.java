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
        if(this.checkFirstAddObject()) {
            Object[] objectsTemp = new Object[this.objects.length + 1];
            System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
            this.objects = objectsTemp;
            this.objects[this.index] = object;
        }

        boolean addObject = !this.searchDuplicate(object);
        if (addObject) {
            Object[] objectsTemp = new Object[this.objects.length + 1];
            System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
            this.objects = objectsTemp;
            this.objects[this.index] = object;
            this.index++;
        }
        return addObject;
    }

    private boolean checkFirstAddObject() {
        boolean firstAddTrue = false;
        if (this.objects.length == 0) {
            firstAddTrue = true;
        }
        return firstAddTrue;
    }

    // searchDuplicate -
    private boolean searchDuplicate(E object) {
        boolean sameObject = false;
        for (int position = 0; position <= this.index; position++) {
            if(this.objects[position] != null && object.equals(this.objects[position])) {
                sameObject = true;
                break;
            }
        }
        return sameObject;
    }

    public E get(int position) {
        return (E) this.objects[position];
    }


    @Override
    public int size() {
        return this.objects.length;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
