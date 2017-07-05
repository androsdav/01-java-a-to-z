package com.adidyk;

public class Cycle {

    // hasCycle - return true if linked list is cycle, and false if linked list is not cycle
    public <E> boolean  hasCycle(SimpleNode<E> first) {
        SimpleLinkedList<SimpleNode<E>> list = new SimpleLinkedList<>();
        list.add(first);
        boolean result = false;
        for (SimpleNode<E> item = first.next; item != null; item = item.next) {
            for (SimpleNode<E> node : list) {
                if(node.hashCode() == item.hashCode()) {
                    result = true;
                    break;
                }
            }
            if(result) break;
            else list.add(item);
        }
        return result;
    }

}