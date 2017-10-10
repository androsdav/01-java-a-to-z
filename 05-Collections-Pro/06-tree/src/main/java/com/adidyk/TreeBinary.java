package com.adidyk;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * ------------------------------------------------------------------------------------------------------------
 * Class TreeBinary is search binary tree. This is container TreeBinary don`t have duplicate elements.
 * Root element has only two children elements: left and right. Element to left of root is less than root,
 * and right is greater than root.
 * Container of Tree is implemented on elementary search binary tree tree where each element (parent -
 * object of static class Node<E>) of structure can contain two object Node<E> (left and right).
 * Object of class Node<E> has next parameters:
 * -> left  - link on object of class Node<E>;
 * -> value - value its generic type <E>;
 * -> right - link on object of class Node<E>.
 * ------------------------------------------------------------------------------------------------------------
 * Class Tree has next method:
 * -> add  - adds new element to tree-binary;
 * -> iterator - returns next element from tree-binary.
 * ------------------------------------------------------------------------------------------------------------
 * Class TreeBinary can use method for-each and method iterator.
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
     * add - adds new element to tree-binary.
     * @param value - is generic type <E> and new added element.
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
     * addTo - adds new element to tree-binary.
     * @param node - is first element from tree-binary.
     * @param value - is generic type <E> and new added element.
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
     * iterator - create new object of class SimpleIterator and returns it.
     * @return returns new object of class SimpleIterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator(this.root);
    }

    /**
     * Class SimpleIterator.
     */
    private class SimpleIterator implements Iterator<E> {

        /**
         * @param root - is first element of tree-binary.
         */
        private Node<E> root;

        /**
         * @param order - is deque where all elements tree-binary arrive.
         */
        private ArrayDeque<Node<E>> order;

        /**
         * @param list - is deque where all elements tree-binary arrive for iterator.
         */
        private ArrayDeque<E> list;

        /**
         *
         * @param root - is first element of tree-binary.
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
            this.order.addLast(this.root);
            this.addChildToOrder();
        }

        /**
         * addChildToOrder - adds children to deque.
         */
        private void addChildToOrder() {
            do {
                Node<E> node = order.pollFirst();
                this.list.addLast(node.value);
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
