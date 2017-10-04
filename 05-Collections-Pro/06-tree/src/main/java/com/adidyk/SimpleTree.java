package com.adidyk;

import java.util.List;

/**
 * Interface SimpleTree for create elementary Tree by.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 * @param <E> the type element of container for structure Tree.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * add - adds a new child to the parent.
     * @param parent - is generic type <E>.
     * @param child - is generic type <E>.
     * @return returns true if child added to the parent or returns false if child don`t added
     * to the parent.
     */
    boolean add(E parent, E child);

    /**
     * @param parent - is generic type <E>.
     * @return returns list all child for inputted parent.
     */
    List<?> get(E parent);

}
