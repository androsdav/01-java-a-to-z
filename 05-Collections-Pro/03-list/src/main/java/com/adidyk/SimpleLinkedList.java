package com.adidyk;

public class SimpleLinkedList {

    private String prev;
    private String item;
    private String next;

    SimpleLinkedList() {
        this.prev = null;
        this.item = null;
        this.next = null;
    }


    public void add(String item) {
        this.item = item;
    }

    public String get(int index) {
        return null;
    }

    private class Node {
        private String prev;
        private String item;
        private String next;


    }


}
