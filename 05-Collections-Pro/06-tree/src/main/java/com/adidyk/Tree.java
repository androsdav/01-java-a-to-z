package com.adidyk;

import java.util.Iterator;


public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * @param parent - is parent for child.
     * @param child - is child for parent.
     * @return returns true if child search your parent or false if child don`t search your parent.
     */
    @Override
    public boolean add(E parent, E child) {
        return false;
    }

    /**
     * @return null now while method iterator don`t have your realisation.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
