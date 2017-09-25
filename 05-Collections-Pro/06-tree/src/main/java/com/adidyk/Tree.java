package com.adidyk;

import java.util.ArrayDeque;
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
     * @param result is result.
     */
    private List<Node<E>> result;

    /**
     * @param newNode is node.
     */
    private Node<E> newNode = null;

    /**
     * order is order.
     */
    private ArrayDeque<Node<E>> order = new ArrayDeque<>();

    /**
     * @param parent - is parent for child.
     * @param child - is child for parent.
     * @return returns true if child search your parent or false if child don`t search your parent.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean addTrue = false;
        if (this.root == null) {
            this.root = new Node<>(parent);
            addTrue = true;
        } else if (parent.compareTo(this.root.value) == 0) {
            if (child.compareTo(this.root.value) != 0) {
                Node<E> newChild = new Node<>(child);
                this.root.child.add(newChild);
                addTrue = true;
            }
        } else {
            addTrue = this.addChildToParent(parent, child, this.root);
        }
        return addTrue;
    }

    /**
     * @param parent parent.
     * @param child child.
     * @param root root.
     * @return true or false.
     */
    private boolean addChildToParent(E parent, E child, Node<E> root) {
        boolean parentSearch = false;
        boolean childDouble = false;
        for (Node<E> node : root.child) {
            if (child.compareTo(node.value) == 0) {
                childDouble = true;
                break;
            } else
                if (parent.compareTo(node.value) == 0) {
                this.newNode = node;
            }
            this.order.addLast(node);
        }
        if (this.order.peekFirst() != null && !childDouble) {
            this.addChildToParent(parent, child, this.order.pollFirst());
        } else
            if (this.newNode != null && !childDouble) {
                Node<E> newChild = new Node<>(child);
                this.newNode.child.add(newChild);
                this.newNode = null;
                parentSearch = true;
            }
        this.order.clear();
        return parentSearch;
    }

    /**
     * @param parent sucks.
     * @return root.
     */
    public List<Node<E>> get(E parent) {
        List<Node<E>> result = null;
        if (parent != null) {
            if (parent.compareTo(this.root.value) == 0) {
                result = this.root.child;
            } else {
                result = this.getChildrenToParent(parent, this.root);
            }
        }
        return result;
    }

    /**
     *
     * @param parent parent.
     * @param root root.
     * @return sucks.
     */
    private List<Node<E>> getChildrenToParent(E parent, Node<E> root) {
        boolean listSearch = false;
        List<Node<E>> childList = null;
        for (Node<E> node : root.child) {
            if (parent.compareTo(node.value) == 0) {
                childList = node.child;
                listSearch = true;
                break;
            }
            this.order.addLast(node);
        }
        if (this.order.peekFirst() != null && !listSearch) {
            this.getChildrenToParent(parent, this.order.pollFirst());
        }
        return childList;
    }

        /*int index = 0;
        for (Node<E> ittem) {
        }
        }
        if (parent.compareTo(root.value) == 0) {
            Node<E> newChild = new Node<>(child);
            root.child.add(newChild);
        } else {
            addChildToParent(parent, child, root.child.get(index));
        }
        */
/* tree sucks
    /**
     * @param parent parent.
     * @param child child.
     * @param listChild children.
     */
/*
    private void addChildToParent(E parent, E child, List<Node<E>> listChild) {
        for (Node<E> item : listChild) {
            if (parent.compareTo(item.value) == 0) {
                Node<E> newChild = new Node<>(child);
                item.child.add(newChild);
                break;
            } else {
                this.addChildToParent(parent, child, item.child);
            }
        }
    }*/
        /*
        listChild.stream().filter(item -> item != null).forEach(item -> {
            addChildToParent(parent, child, item.child);
            if (parent.compareTo(item.value)) {
                Node<E> newChild = new Node<>(child);
                item.child.add(newChild);
            }
        });
        */
/*
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
/*
    /**
     *
     * @param parent sucks.
     * @param nodeList is node.
     * @return all object by class Node.
     */
/*
    private List<Node<E>> getChildren(E parent, List<Node<E>> nodeList) {
        boolean searchTrue = false;
        List<Node<E>> result = null;
        for (Node<E> node : nodeList) {
            if (parent.compareTo(node.value) == 0) {
                this.result = node.child;
                searchTrue = true;
            }
            if (!searchTrue) {
                this.getChildren(parent, node.child);
            }

            if (searchTrue) {
                break;
            }
        }
        // sucks
        return this.result;
    }
    */
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

        /*
        /**
         *
         * @return all information for parent.
         */
        @Override
        public String toString() {
            return String.format("%s", this.value);
        }
    }
}
