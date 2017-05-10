package com.adidyk;

import java.util.Collection;

public class Productivity {

    public long add(Collection<String> collection, String line, int amount) {
        long start = System.nanoTime();
        for (int index = 0; index < amount; index++) {
            collection.add(line);
        }
        long end = System.nanoTime();
        return (end - start) / amount;
    }

    public long delete(Collection<String> collection, int amount) {
        long start = System.nanoTime();
        //for(int index = 0; index < amount; index ++) {
            collection.remove(0);
        collection.remove(1);
        collection.remove(2);
        //}
        long ned = System.nanoTime();
        return ned - start;
    }


}
