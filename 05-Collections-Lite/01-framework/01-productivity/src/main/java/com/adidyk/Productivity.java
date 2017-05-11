package com.adidyk;

import java.util.Collection;
import java.util.Iterator;

public class Productivity {

    public long add(Collection<String> collection, String line, int amount) {
        long start = System.nanoTime();
        for (int index = 0; index < amount; index++) {
            collection.add(line + index);
        }
        long end = System.nanoTime();
        return (end - start) / amount;
    }

    public long delete(Collection<String> collection, int amount) {
        long start = System.nanoTime();
        Iterator itr = collection.iterator();
        int index = 0;
        while(itr.hasNext() && index < amount) {
            itr.next();
            itr.remove();
            index++;
        }
        long ned = System.nanoTime();
        return (ned - start) / amount;
    }


}
