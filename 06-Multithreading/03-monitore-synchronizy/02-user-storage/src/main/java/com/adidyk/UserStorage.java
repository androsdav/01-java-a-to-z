package com.adidyk;

//import static java.lang.Math.round;
import java.util.Arrays;
import static java.lang.Math.round;

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
     * @return - is true.
     */
    boolean add(E object) {
        boolean isAdded = true;
        if (this.index == 0) {
            this.addObject(object);
        } else {
            isAdded = !this.searchDuplicate(object);
            if (isAdded) {
                this.addObject(object);
            }
        }
        return isAdded;
    }

    /**
     * update - update user.
     * @param object - is object.
     * @return true.
     */
    boolean update(E object) {
        return true;
    }

    /**
     * remove - deletes object by object from array of objects, and shifts array of objects to left by one position,
     * starting with the index of set object.
     * @param object - is object.
     * @return true.
     */
    boolean delete(E object) {
        boolean isDeleted = false;
        for (int index = 0; index < this.index; index++) {
            if (this.objects[index].equals(object)) {
                System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - 1 - index);
                this.index--;
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }

    /**
     * addObject - adds object to Set-Array container.
     * @param object - is object.
     */
    private void addObject(E object) {
        if (this.index == this.objects.length) {
            Object[] objectsTemp = new Object[(int) round(1.5 * this.objects.length)];
            System.arraycopy(this.objects, 0, objectsTemp, 0, this.objects.length);
            this.objects = objectsTemp;
        }
        this.objects[this.index++] = object;
    }

    /**
     * searchDuplicateByBinary - search duplicate by hash code and uses a binary search algorithm
     * and return true if object is duplicate in Set-Array, false - if object not duplicate in Set-Array.
     * @param object - is object.
     * @return true.
     */
    private boolean searchDuplicate(E object) {
        boolean duplicate = false;
        for (int index = 0; index < this.index; index++) {
            if (object.equals(this.objects[index])) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }




/*        boolean sameObject = false;
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
        */

    /**
     * get - returns object by index from array of objects.
     * @param index - is index.
     * @return - returns object.
     */
    public E get(int index) {
        return (E) this.objects[index];
    }

    @Override
    public String toString() {
        return String.format("%s%s%s%s%s%s", "UserStorage{", "objects=", Arrays.toString(objects), ", index=", index, '}');
    }
}