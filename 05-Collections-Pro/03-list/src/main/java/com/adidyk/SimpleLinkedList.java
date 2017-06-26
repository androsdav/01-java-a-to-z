package com.adidyk;

public class SimpleLinkedList<E> {

    private String prev;
    private String item;
    private String next;

    private Node node;
    private Node<E> first;
    private Node<E> last;
    private int size;

    SimpleLinkedList() {
        this.last = null;
        this.first = null;

    }

    public void add(E item) {
        this.last = new Node<>(this.last, item, null);
        this.size++;
        if (this.size == 1) {
            this.first = this.last;
        }
    }

    public E get(int index) {
        Node<E> node = null;
    //    if (this.size > 0 && index < this.size) {

        if (index == 0) {
            node = this.first;
        } else if(index == this.size - 1) {
            node = this.last;
        } else {
            if (index > 0 && index < this.size) {
                node = first;
                for (int position = 0; position < this.size; position++) {
                    node = node.next;
                    if (position == index) {
                        break;
                    }
                }

            }
        }
       return node.item;
    }

    public E getFirst() {
        return this.first.item;
    }

    public E getLast(){
        return this.last.item;
    }

    public int getSize() {
        return this.size;
    }

    /*
    private class Node {
        private String prev;
        private String item;
        private String next;


    }

*/

}
