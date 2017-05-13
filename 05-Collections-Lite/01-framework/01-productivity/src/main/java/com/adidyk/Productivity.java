package com.adidyk;

import java.util.*;

public class Productivity {

    public long add(Collection<String> collection, String line, int amount) {
        long start = System.nanoTime();
        for (int index = 0; index < amount; index++) {
            collection.add(line + index);
        }
        long end = System.nanoTime();
        return (end - start);
    }


    public long insert(Collection<String> collection, String line, int amount) {
        //ArrayList<String> test = new ArrayList<>();
        //collection.add(1, "1");
//        Iterator itr = collection.iterator();

//        Collection<String> list = new ArrayList<>();
  //      Iterator<String> itr = list.iterator();
        ListIterator<String> listItr = (ListIterator<String>) collection.iterator();
        int index = 0;
        while(listItr.hasNext()) {
            listItr.add(line);
        }

        // ListIterator itr = collection.listIterator();
       // int index = 0;
       // while (itr.hasNext() && index < amount) {
       //     itr.add
        //}
      //  collection.get(1);
      //  collection.set(1, line);
        return 1;
    }




    public long delete(Collection<String> collection, int amount) {
        long start = System.nanoTime();
        Iterator<String> itr = collection.iterator();
        int index = 0;
        while (itr.hasNext() && index < amount) {
            itr.next();
            itr.remove();
            index++;
        }
        long ned = System.nanoTime();
        return (ned - start) / amount;
    }


}
