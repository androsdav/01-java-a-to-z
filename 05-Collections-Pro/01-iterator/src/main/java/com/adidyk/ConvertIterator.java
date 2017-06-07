package com.adidyk;

import java.util.Iterator;

public class ConvertIterator implements IteratorIterator {

    private final Iterator<Iterator<Integer>> it;
    private Iterator<Integer> itAll;

    ConvertIterator(Iterator<Iterator<Integer>> it) {
        this.it = it;
    }


    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        Iterator<Integer> result;
        while(it.hasNext()) {
     //       result = it.next().next();
        }
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return it.next();
    }

    public void remove() {
    }

}
