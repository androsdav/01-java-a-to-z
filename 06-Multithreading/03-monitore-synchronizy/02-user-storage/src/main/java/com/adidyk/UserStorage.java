package com.adidyk;

//import static java.lang.Math.round;

/** Class User for create user (object) with params: id, amount.
 * @param <E> - is generic.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 26.07.2017.
 * @version 1.0.
 */
public class UserStorage<E> {

    /**
     * @param objects - is objects.
     */
    private Object[] objects;

    /**
     * @param index - is index.
     */
    private int index = 0;

    /**
     * UserStorage - constructor.
     */
    UserStorage() {
        this.objects = new Object[10];
    }

    /**
     * UserStorage - constructor.
     * @param size - is size.
     */
    UserStorage(int size) {
        this.objects = new Object[size];
    }

    /**
     * add - adds object to array of objects.
     * @param object - is object.
     */
    public boolean add(E object) {
        boolean isAdded = true;
        if (this.objects.length == 0) {
            this.addObject(object);
        }  else if(isAdded = !this.searchDuplicateByBinary(object)) {
            this.addObject(object);
        }
        return isAdded;
    }

    /**
     * addObject - adds object to Set-Array container.
     * @param object - is object.
     */
    private void addObject(E object) {
        Object[] objectsTemp = new Object[this.objects.length + 1];
        System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
        this.objects = objectsTemp;
        this.objects[this.index++] = object;
    }

    /*
    /**
     * searchDuplicateByBinary - search duplicate by hash code and uses a binary search algorithm
     * and return true if object is duplicate in Set-Array, false - if object not duplicate in Set-Array.
     * @param object - is object.
     * @return true.
     */
    /*
    private boolean searchDuplicateByBinary(E object) {
        boolean sameObject = false;
        int left = 0;
        int right = this.objects.length - 1;
        int index;
        do {
            index = (right + left) / 2;
            if (this.objects[index].hashCode() == object.hashCode())
                sameObject = true;
            else if (this.objects[index].hashCode() > object.hashCode() && right - left != 0)
                right = index - 1;
            else if (right - left != 0)
                left = index + 1;
        } while((index != left && index != right ) && !sameObject);
        return sameObject;
    }

    /**
     * get - returns object by index from array of objects.
     * @param index - is index.
     * @return - returns object.
     */
    /*
    public E get(int index) {
        return (E) this.objects[index];
    }
    */




}