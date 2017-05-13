package com.adidyk;

import java.util.*;

public class Productivity {

    // add -
    long add(Collection<String> collection, String line, int amount) {
        long start = System.nanoTime();
        for (int index = 0; index < amount; index++) {
            collection.add(line + index);
        }
        long end = System.nanoTime();
        return (end - start);
    }

    // insert -
    public long insert(Collection<String> collection, String line, int amount) {
        long start = System.nanoTime();
        ListIterator<String> listItr = (ListIterator<String>) collection.iterator();
        int index = 0;
        while(listItr.hasNext() && index < amount) {
            listItr.add(line);
            listItr.next();
            index++;
        }
        long end = System.nanoTime();
        return (end - start) / amount;
    }

    // delete -
    public long delete(Collection<String> collection, int amount) {
        long start = System.nanoTime();
        Iterator<String> itr = collection.iterator();
        int index = 0;
        while (itr.hasNext() && index < amount) {
            itr.next();
            itr.remove();
            index++;
        }
        long end = System.nanoTime();
        return (end - start) / amount;
    }


}
