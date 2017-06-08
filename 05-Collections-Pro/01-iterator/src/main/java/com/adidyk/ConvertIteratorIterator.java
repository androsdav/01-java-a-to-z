package com.adidyk;

import java.util.Iterator;

public class ConvertIteratorIterator implements IteratorIterator {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new AdvancedIterator(it);
    }

    private class AdvancedIterator implements Iterator {

        private final Iterator<Iterator<Integer>> iterators;
        private Iterator<Integer> iterator;

        AdvancedIterator(Iterator<Iterator<Integer>> it) {
            this.iterators = it;
            this.iterator = it.next();
        }

        private void iteratorNext() {
            if (!this.iterator.hasNext()) {
                this.iterator = this.iterators.next();
            }
        }

        public boolean hasNext() {
            return (this.iterators.hasNext() || this.iterator.hasNext());
        }

        public Object next() {
            this.iteratorNext();
            return this.iterator.next();
        }

        public void remove() {
        }

    }

}