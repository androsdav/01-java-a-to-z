package com.adidyk;

import java.util.Iterator;

public class ConvertIterator implements IteratorIterator {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new NewIterator();
    }

    public class NewIterator implements Iterator {


        public boolean hasNext() {
            return false;
        }

        public Object next() {
            return null;
        }

        public void remove() {
        }

    }


}
/*
    private Iterator<Iterator<Integer>> iteratorIt;
    private Iterator<Integer> iteratorNext;



    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        }
        return public class TestIterator() {


    };

/*
    public void iteratorNext() {
        if (this.iteratorIt.hasNext()) {
            this.iteratorNext = this.iteratorIt.next();
        }

    }

    public boolean hasNext() {
        return true;
    }

    public Object next() {
        this.iteratorNext();
        return iteratorIt.next();
    }

    public void remove() {
    }
*/

