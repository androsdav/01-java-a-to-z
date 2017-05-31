package com.adidyk;

import java.util.Iterator;


    public class IteratorDoubleArray implements Iterator {

        private final int[][] array;
        private int indexI = 0;
        private int indexJ = 0;

        public IteratorDoubleArray(int[][] array) {
            this.array = array;
        }


        @Override
        public boolean hasNext() {
            return this.indexI < this.array.length;
        }

        @Override
        public Object next() {
            if (this.indexJ >= this.array[this.indexI].length) {
                this.indexI++;
                this.indexJ = 0;
            }
            return this.array[this.indexI][this.indexJ++];
        }

        @Override
        public void remove() {
        }
}
