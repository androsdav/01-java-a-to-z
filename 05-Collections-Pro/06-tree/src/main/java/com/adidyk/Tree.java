package com.adidyk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * * This is container don`t has duplicate elements.
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
            addTrue = this.addRoot(parent, child);
        }
        if (parent.compareTo(this.root.value) == 0) {
            if (child.compareTo(this.root.value) != 0) {
                addTrue = this.addChildToRoot(child, this.root);
            }
        } else if (child.compareTo(this.root.value) != 0) {
            addTrue = this.addChildToParent(parent, child, this.root);
        }
        return addTrue;
    }

    /**
     * @param parent parent.
     * @param child child.
     * @return true or false.
     */
    private boolean addRoot(E parent, E child) {
        boolean addTrue = false;
        this.root = new Node<>(parent);
        if (parent.compareTo(child) != 0) {
            Node<E> newChild = new Node<>(child);
            this.root.child.add(newChild);
            addTrue = true;
        }
        return addTrue;
    }

    /**
     * @param child child.
     * @param root root.
     * @return true or false.
     */
    private boolean addChildToRoot(E child, Node<E> root) {
        boolean childDouble = false;
        ArrayDeque<Node<E>> order = new ArrayDeque<>();
        order.addLast(root);
        do {
            Node<E> listChild = order.pollFirst();
            for (Node<E> node : listChild.child) {
                if (child.compareTo(node.value) == 0) {
                    childDouble = true;
                    break;
                }
                if (node.child.size() != 0) {
                    order.addLast(node);
                }
            }
            if (childDouble) {
                break;
            }
        } while (!order.isEmpty());
        if (!childDouble) {
            Node<E> newChild = new Node<>(child);
            this.root.child.add(newChild);
        }
        return !childDouble;
    }

    /**
     * @param parent parent.
     * @param child child.
     * @param root root.
     * @return true or false.
     */
    private boolean addChildToParent(E parent, E child, Node<E> root) {
        boolean childDouble = false;
        boolean addTrue = false;
        Node<E> newNode = null;
        ArrayDeque<Node<E>> order = new ArrayDeque<>();
        order.addLast(root);
        do {
            Node<E> listChild = order.pollFirst();
            for (Node<E> node : listChild.child) {
                if (child.compareTo(node.value) == 0) {
                    childDouble = true;
                    break;
                }
                if (parent.compareTo(node.value) == 0) {
                    newNode = node;
                }
                if (node.child.size() != 0) {
                    order.addLast(node);
                }
            }
            if (childDouble) {
                break;
            }
        } while (!order.isEmpty());
        if (!childDouble && newNode != null) {
            Node<E> newChild = new Node<>(child);
            newNode.child.add(newChild);
            addTrue = true;
        }
        return addTrue;
    }


    /**
     * @param parent sucks.
     * @return root.
     */
    @Override
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
     * @param parent parent.
     * @param root root.
     * @return sucks.
     */
    private List<Node<E>> getChildrenToParent(E parent, Node<E> root) {
        boolean listSearch = false;
        List<Node<E>> childList = null;
        ArrayDeque<Node<E>> order = new ArrayDeque<>();
        order.addLast(root);
        do {
            Node<E> listChild = order.pollFirst();
            for (Node<E> node : listChild.child) {
                if (parent.compareTo(node.value) == 0) {
                    childList = node.child;
                    listSearch = true;
                }
                if (node.child.size() != 0) {
                    order.addLast(node);
                }
            }
            if (listSearch) {
                break;
            }
        } while (!order.isEmpty());
        return childList;
        /*
        boolean listSearch = false;
        List<Node<E>> childList = null;
        if (root.child.size() != 0) {
            for (Node<E> node : root.child) {
                if (parent.compareTo(node.value) == 0) {
                    childList = node.child;
                    listSearch = true;
                    break;
                }
                this.order.addLast(node);
            }
        }
        if (this.order.peekFirst() != null && !listSearch) {
            this.getChildrenToParent(parent, this.order.pollFirst());
        }
        return childList;
        */
    }

    /*
    /**
     * @param parent parent.
     * @param root root.
     * @return sucks.
     */
    /*
    private List<Node<E>> getChildrenToParent(E parent, Node<E> root) {
        boolean listSearch = false;
        List<Node<E>> childList = null;
        if (root.child.size() != 0) {
            for (Node<E> node : root.child) {
                if (parent.compareTo(node.value) == 0) {
                    childList = node.child;
                    listSearch = true;
                    break;
                }
                this.order.addLast(node);
            }
        }
        if (this.order.peekFirst() != null && !listSearch) {
            this.getChildrenToParent(parent, this.order.pollFirst());
        }
        return childList;
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
         * Task bank do not tell me
         * @return all information for parent.
         */
        @Override
        public String toString() {
            return String.format("%s", this.value);
        }
    }
}
