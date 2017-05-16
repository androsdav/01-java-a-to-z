package com.adidyk;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class Productivity {

    // add - adds elements at end of Collections
    long add(Collection<String> collection, String string, int amount) {
        long start = System.nanoTime();
        for (int index = 0; index < amount; index++) {
            collection.add(string + index);
        }
        long end = System.nanoTime();
        return (end - start);
    }

    // insert - inserts elements at beginning of List
    long insert(List<String> collection, String string, int amount) {
        long start = System.nanoTime();
        ListIterator<String> listItr = collection.listIterator();
        int index = 0;
        while(listItr.hasNext() && index < amount) {
            listItr.add(string + index);
            index++;
        }
        long end = System.nanoTime();
        return (end - start);
    }

    // delete - deletes amount elements at beginning of Collections
    long delete(Collection<String> collection, int amount) {
        long start = System.nanoTime();
        Iterator<String> itr = collection.iterator();
        int index = 0;
        while (itr.hasNext() && index < amount) {
            itr.next();
            itr.remove();
            index++;
        }
        long end = System.nanoTime();
        return (end - start);
    }

}
