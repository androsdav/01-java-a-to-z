package com.adidyk;

public class Cycle {

    public <E> void  hasCycle(SimpleNode<E> first) {
        int firstHashCode = first.hashCode();
        int index = 0;
        for (SimpleNode<E> item = first.next; item != null; item = item.next) {

            if (firstHashCode == item.hashCode()) {
                System.out.println("Cycle");
                break;
            }

            System.out.println("["+index++ +"]" + " itemItem: " +item.item);
            System.out.println("   " + " hashCode: " +item.item.hashCode());
            System.out.println("   " + " hashCode: " +item.hashCode());

            //System.out.println("item: " +item.item);
            //System.out.println("link: " +item);
            //System.out.println("hash: " +item.hashCode());
        }

    }

}
