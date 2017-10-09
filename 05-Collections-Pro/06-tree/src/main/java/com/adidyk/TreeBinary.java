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
 * -> value - value its generic type <E>.
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
class TreeBinary<E extends Comparable<E>> implements SimpleTreeBinary<E> {

    /**
     * @param root - first element (root) in the tree-binary.
     */
    private Node<E> root;

    /**
     * add - adds new value to tree.
     * @param value - is generic type <E>.
     */
    @Override
    public void add(E value) {
        if (this.root == null) {
            this.root = new Node<>(null, value, null);
        } else {
            this.addTo(this.root, value);
        }
    }

    /**
     * @param node - is node.
     * @param value - is value.
     */
    private void addTo(Node<E> node, E value) {
        if (value.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new Node<>(null, value, null);
            } else {
                this.addTo(node.left, value);
            }
        } else if (value.compareTo(node.value) > 0) {
            if (node.right == null) {
                node.right = new Node<>(null, value, null);
            } else {
                this.addTo(node.right, value);
            }
        }
    }

    /**
     *
     * @return null now.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator(this.root);
    }

    /**
     * Class SimpleIterator is iterator.
     */
    private class SimpleIterator implements Iterator<E> {

        /**
         * @param root - is first element of tree.
         */
        private Node<E> root;

        /**
         * @param order - is deque.
         */
        private ArrayDeque<Node<E>> order;

        /**
         * @param list - is deque all element of tree for iterator.
         */
        private ArrayDeque<E> list;

        /**
         *
         * @param root is root.
         */
        SimpleIterator(Node<E> root) {
            this.init(root);
        }

        /**
         * @param root - is first element of tree.
         */
        private void init(Node<E> root) {
            this.order = new ArrayDeque<>();
            this.list = new ArrayDeque<>();
            this.root = root;
            this.list.addLast(this.root.value);
            this.order.addLast(this.root);
            this.addChildToOrder();
        }

        /**
         * addChildToOrder - adds children to deque.
         */
        private void addChildToOrder() {
            do {
                Node<E> node = order.pollFirst();
                if (node.left != null) {
                    this.order.addLast(node.left);
                }
                if (node.right != null) {
                    this.order.addLast(node.right);
                }
            } while (!order.isEmpty());
        }

        /**
         *
         * @return true.
         */
        @Override
        public boolean hasNext() {
            return !this.list.isEmpty();
        }

        /**
         *
         * @return true.
         */
        @Override
        public E next() {
            return this.list.pollFirst();
        }

        /**
         * not realisation.
         */
        @Override
        public void remove() {
        }
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
