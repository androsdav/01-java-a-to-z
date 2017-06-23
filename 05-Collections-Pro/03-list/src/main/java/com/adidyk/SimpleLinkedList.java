package com.adidyk;

public class SimpleLinkedList {

    private String prev;
    private String item;
    private String next;

    private Node node;
    private Node last;


    SimpleLinkedList() {
        this.last = new Node(null, null, null);
    }

    public void add(String item) {
        this.last = new Node(this.last, item, null);

    }

    public Node getLast(){
        return this.last;
    }

    public String get(int index) {
        return null;
    }

    /*
    private class Node {
        private String prev;
        private String item;
        private String next;


    }

*/

}
