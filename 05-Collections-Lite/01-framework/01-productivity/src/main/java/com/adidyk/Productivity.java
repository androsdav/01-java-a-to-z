package com.adidyk;

import java.util.*;

public class Productivity {

    // add -
    long add(Collection<String> collection, String string, int amount) {
        long start = System.nanoTime();
        for (int index = 0; index < amount; index++) {
            //collection.add(this.randomString());
            collection.add(string + index);
        }
        long end = System.nanoTime();
        return (end - start) / amount;
    }

    // insert -
    public long insert(List<String> collection, String string, int amount) {
        long start = System.nanoTime();
        ListIterator<String> listItr = collection.listIterator();
        int index = 0;
        while(listItr.hasNext() && index < amount) {
            listItr.add(string + index);
            //listItr.next();

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
    public String randomString() {
        String symbols = "qwerty";
        StringBuilder randString = new StringBuilder();
        int count = (int) (Math.random() * 30);
        for (int i = 0; i < count; i++) {
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        return String.valueOf(randString);
    }
}
