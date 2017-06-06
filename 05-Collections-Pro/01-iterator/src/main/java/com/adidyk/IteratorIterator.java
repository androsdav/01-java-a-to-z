package com.adidyk;

import java.util.Iterator;

public class IteratorIterator implements Iterator {

    private final Iterator<Integer> it;
    private int index = 0;

    IteratorIterator(Iterator<Integer> it) {
        this.it = it;
    }


    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return null;

    }

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            return null;
        }

        public void remove() {

        }

}
