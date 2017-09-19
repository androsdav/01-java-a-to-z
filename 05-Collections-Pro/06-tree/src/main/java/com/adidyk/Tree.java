package com.adidyk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ------------------------------------------------------------------------------------------------------------
 * Class SimpleHashMap is HashTable structure by analogy as in Java. SimpleHashMap is implemented on arrays where
 * each cell of the array can contain linked list object Node. Object of class Node has next parameters:
 * -> hash  - hash value by key;
 * -> key   - key its generic type <K>;
 * -> prev  - link on previous object of class Node;
 * -> value - value its generic type <V>;
 * -> next  - link on next object of class Node.
 *------------------------------------------------------------------------------------------------------------
 * Class SimpleHashMap have next method:
 * -> put    - adds key and value in array, where is bucket number is calculated from hash code of key;
 * -> get    - returns value by key;
 * -> remove - remove object of class Node by key.
 *------------------------------------------------------------------------------------------------------------
 * Class SimpleHashMap can use method for-each and method iterator.
 * @param <E> - the type of keys maintained by this map.
 *------------------------------------------------------------------------------------------------------------
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 * ------------------------------------------------------------------------------------------------------------
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * @param root is root.
     */
    private Node<E> root = null;

    /**
     * @param parent - is parent for child.
     * @param child - is child for parent.
     * @return returns true if child search your parent or false if child don`t search your parent.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean addTrue = false;
        if (this.root == null) {
            this.addRoot(parent, child);
            addTrue = true;
        } else if (parent.equals(this.root.value)) {
            this.addChildToRoot(child);
        } else {
            List<Node<E>> listChild = this.root.child;
            this.addChildToParent(parent, child, listChild);
        }
        return addTrue;
    }

    /**
     *
     * @param parent parent.
     * @param child parent.
     */
    private void addRoot(E parent, E child) {
        this.root = new Node<>(parent);
        Node<E> newChild = new Node<>(child);
        this.root.child.add(newChild);
    }

    /**
     *
     * @param child child.
     */
    private void addChildToRoot(E child) {
        Node<E> newChild = new Node<>(child);
        this.root.child.add(newChild);
    }

    /**
     *
     * @param parent parent.
     * @param child child.
     * @param listChild children.
     */
    private void addChildToParent(E parent, E child, List<Node<E>> listChild) {
        listChild.stream().filter(item -> item != null).forEach(item -> {
            addChildToParent(parent, child, item.child);
            if (parent.equals(item.value)) {
                Node<E> newChild = new Node<>(child);
                item.child.add(newChild);
            }
        });
    }

    /**
     *
     * @param parent parent.
     * @param child child.
     */
    /*
    private void searchParent(E parent, E child) {
        for (Node<E> item : this.root.child) {
            if (item.value.equals(parent)) {
                Node<E> newChild =

            }
        }

    }
    */

    /**
     *
     * @return root.
     */
    public Node<E> getRoot() {
        return this.root;
    }

    /**
     * @return null now while method iterator don`t have your realisation.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     *
     * @param <E> - the type of class.
     */
    private static class Node<E> {

        /**
         * <E> - its class.
         */
        private E value;

        /**
         * <E> - its class.
         */
        private List<Node<E>> child;

        /**
         * Constructor.
         * @param value is value.
         */
        Node(E value) {
            this.value = value;
            this.child = new ArrayList<>();
        }

        /**
         *
         * @param children add children to parent.
         */
        private void addChildren(Node<E> children) {
            this.child.add(children);
        }

        /**
         *
         * @return all information for parent.
         */
        @Override
        public String toString() {
            return String.format("%s%s%s%s%s%s%n", "Node{//", "value=", this.value, "->child=", this.child, "//}");
        }
    }
}
