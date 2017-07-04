package com.adidyk;

public class Cycle {

    // hasCycle - return true if linked list is cycle, and false if linked list is not cycle
    public <E> boolean  hasCycle(SimpleNode<E> first) {
        int firstHashCode = first.hashCode();
        boolean result = false;
        for (SimpleNode<E> item = first.next; item != null; item = item.next) {
            if (firstHashCode == item.hashCode()) {
                result = true;
                break;
            }
        }
        return result;
    }

}