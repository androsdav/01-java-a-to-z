package com.adidyk;

/**
 * Interface SimpleMap for create structure HashTable by data key and value.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 * @param <E> the type of keys maintained by this map.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     *
     * @param parent - is parent for child.
     * @param child - is child for parent.
     * @return returns true if child is parent or returns false is child don`t added.
     */
    boolean add (E parent, E child);
}
