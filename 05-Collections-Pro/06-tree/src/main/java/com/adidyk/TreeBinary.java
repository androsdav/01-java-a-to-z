package com.adidyk;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * ------------------------------------------------------------------------------------------------------------
 * Class Tree is Tree elementary structure by "analogy" as in Java.
 * This is container Tree don`t have duplicate elements.
 * Container of Tree is implemented on elementary structure tree where each element (parent -
 * object of static class Node<E>) of structure can contain ArrayList object Node<E> (children).
 * Object of class Node<E> has next parameters:
 * -> value - value its generic type <E>;
 * -> child - link on ArrayList object of class Node<E> (List<Node<E>).
 * ------------------------------------------------------------------------------------------------------------
 * Class Tree has next method:
 * -> add  - adds new child to the parent;
 * -> get  - returns list all child for inputted parent;
 * -> size - returns number of elements in the tree.
 * ------------------------------------------------------------------------------------------------------------
 * Class Tree can use method for-each and method iterator.
 * @param <E> - the type of element maintained by this tree.
 * ------------------------------------------------------------------------------------------------------------
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 * ------------------------------------------------------------------------------------------------------------
 */
public class TreeBinary<E extends Comparable<E>> implements SimpleTreeBinary<E> {

    /**
     * @param root - first element (root) in the tree.
     */
    private Node<E> root;

    /**
     * add - adds new value to tree.
     * @param value - is generic type <E>.
     */
    @Override
    public boolean add(E value) {
        boolean addTrue = false;
        if (this.root == null) {
            this.addRoot(value);
        } else {
            this.addTest(value);

        }

        return addTrue;
    }

    /**
     * add - adds root.
     * @param value - is value.
     */
    private void addRoot(E value) {
        this.root = new Node<>(null, value, null);
    }

    /**
     *
     * @param value - is value.
     */
    private void addTest(E value) {
        ArrayDeque<E> order = new ArrayDeque<>();
        order.addLast(value);
        do {
            if (value.compareTo(order.pollFirst()) > 0) {


            }
        } while (!order.isEmpty());

    }

    /**
     *
     * @return null now.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * ------------------------------------------------------------------------------------------------------------
     * Object of class Node<E> has next parameters:
     * -> value - value its generic type <E>;
     * -> child - link on ArrayList object of class Node<E> (List<Node<E>).
     * ------------------------------------------------------------------------------------------------------------
     * @param <E> - the type of element maintained by this tree.
     * ------------------------------------------------------------------------------------------------------------
     */
    private static class Node<E> {

        /**
         * @param value - is parent (is generic type <E>).
         */
        private E value;

        /**
         * @param left - child that is added to parent (is generic type <E>).
         */
        private Node<E> left;

        /**
         * @param child - child that is added to parent (is generic type <E>).
         */
        private Node<E> right;

        /**
         * Constructor.
         * @param left is value.
         * @param value is value.
         * @param right is value.
         */
        Node(Node<E> left, E value,  Node<E> right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }

        /**
         * toString - returns string format.
         * @return all information for element of tree.
         */
        @Override
        public String toString() {
            return String.format("%s", this.value);
        }

    }
}
