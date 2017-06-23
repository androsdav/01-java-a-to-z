package com.adidyk;

public class Node {

    public Node prev;
    private String item;
    private Node next;

    Node (Node prev, String item, Node next) {
        this.prev = prev;
        this.item = item;
        this. next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public String getItem() {
        return this.item;
    }

    public Node getNext() {
        return this.next;
    }
}
