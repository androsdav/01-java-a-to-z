package com.adidyk;

import java.util.Iterator;

public interface IteratorIterator extends Iterator {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it);

}
