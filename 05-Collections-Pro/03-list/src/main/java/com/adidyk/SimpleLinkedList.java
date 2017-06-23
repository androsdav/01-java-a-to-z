package com.adidyk;

public class SimpleLinkedList {

    private String prev;
    private String item;
    private String next;

    private Node node;
    private Node first;
    private Node last;
    private int size;



    SimpleLinkedList() {
        this.last = null;
        this.first = null;

    }

    public void add(String item) {
        this.last = new Node(this.last, item, null);
        this.size++;
        if (this.size == 1) {
            this.first = this.last;
        }
    }

    public Node getLast(){
        return this.last;
    }

    public String get(int index) {
        Node temp = null;
        if (this.size > 0 && index < this.size) {
            for (int position = 0; index < this.size; index++) {
                temp =

            }
        }
        return "temp";
    }

    /*
    private class Node {
        private String prev;
        private String item;
        private String next;


    }

*/

}
