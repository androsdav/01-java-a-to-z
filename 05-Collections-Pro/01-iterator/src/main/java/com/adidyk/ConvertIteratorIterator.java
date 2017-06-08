package com.adidyk;

import java.util.Iterator;

public class ConvertIteratorIterator implements IteratorIterator {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new AdvancedIterator(it);
    }

    private class AdvancedIterator implements Iterator {

        private final Iterator<Iterator<Integer>> iterators;
        private Iterator<Integer> iterator;
        private int result;

        AdvancedIterator(Iterator<Iterator<Integer>> it) {
            this.iterators = it;
            this.iterator = this.iterators.next();
        }

        private void iteratorNext() {
            if(this.iterator.hasNext()) {
                this.result = this.iterator.next();
            }
            /*
            else if (!this.iterator.hasNext()) {
                this.iterator = this.iterators.next();
            }
            */
        }

        public boolean hasNext() {
            boolean hasNextTrue = true;
            //if (this.iterators.hasNext()) {
            //    hasNextTrue = true;
            //} else {
            //    if (this.iterator.hasNext()) {
            //        hasNextTrue = true;
            //    } else {
            //        hasNextTrue = false;
            //    }
           // }
            return hasNextTrue;
        }

        public Object next() {
            this.iteratorNext();
            return this.result;
        }

        public void remove() {
        }

    }


}










