package com.adidyk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * * Interface SimpleTree for create elementary structure Tree.
 * * This is container don`t has duplicate elements.
 * ------------------------------------------------------------------------------------------------------------
 * Class Tree is Tree elementary structure by "analogy" as in Java.
 * Container of Tree is implemented on elementary structure tree where each element (parent -
 * object of static class Node<E>) of structure can contain ArrayList object Node<E> (children).
 * Object of class Node<E> has next parameters:
 * -> value - value its generic type <E>;
 * -> child - link on ArrayList object of class Node<E> (List<Node<E>).
 *------------------------------------------------------------------------------------------------------------
 * Class Tree has next method:
 * -> add  - adds new child to the parent;
 * -> get  - returns list all child for inputted parent;
 * -> size - returns number of elements in the tree.
 *------------------------------------------------------------------------------------------------------------
 * Class Tree can use method for-each and method iterator.
 * @param <E> - the type of element maintained by this tree.
 *------------------------------------------------------------------------------------------------------------
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 30.08.2017.
 * @version 1.0.
 * ------------------------------------------------------------------------------------------------------------
 */
class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * @param root - first parent (root) in the tree.
     */
    private Node<E> root;

    /**
     * @param size - number of elements in the tree.
     */
    private int size;

    /**
     * Constructor - sets null for the root.
     */
    Tree() {
        this.root = null;
    }

    /**
     * Constructor - sets first parent (this.root) in the tree.
     * @param parent - is parent.
     */
    Tree(E parent) {
        this.root = new Node<>(parent);
        this.size++;
    }

    /**
     * add - adds new child to parent. Implementation is next:
     * -> if tree is empty ( doesn`t have any elements) parent is becoming first element
     *    (this.root) in tree and if parent (@param parent) isn`t equals child (child)
     *    the child added to parent (this.root);
     * -> if tree isn`t empty, method looks for the entered parent (parent) and adds entered child
     *    (child) to parent if entered child isn`t duplicate in tree.
     * @param parent - is parent (is generic type <E>).
     * @param child  - child that is added to parent (is generic type <E>).
     * @return returns true if child added to tree or returns false if child isn`t to tree.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean addTrue = false;
        if (this.root == null) {
            addTrue = this.addRoot(parent, child);
        } else if (parent.compareTo(this.root.value) == 0) {
            if (child.compareTo(this.root.value) != 0) {
                addTrue = this.addChildToRoot(child, this.root);
            }
        } else if (child.compareTo(this.root.value) != 0) {
            addTrue = this.addChildToParent(parent, child, this.root);
        }
        if (addTrue) {
            this.size++;
        }
        return addTrue;
    }

    /**
     * addRoot - if tree is empty (doesn`t have any elements) parent is becoming first element
     * (this.root) in tree and if parent (parent) isn`t equals child (child) the child added
     * to parent (this.root).
     * @param parent - is parent (is generic type <E>).
     * @param child  - child that is added to root-parent (is generic type <E>).
     * @return returns true if child added to tree or returns false if child isn`t to tree.
     */
    private boolean addRoot(E parent, E child) {
        boolean addTrue = false;
        this.root = new Node<>(parent);
        if (parent.compareTo(child) != 0) {
            Node<E> newChild = new Node<>(child);
            this.root.child.add(newChild);
            addTrue = true;
            this.size++;
        }
        return addTrue;
    }

    /**
     * addChildToRoot - if entered parent is first element of tree (root), method searches for duplicates of child
     * entered in tree. If duplicate is found, search stops and child isn`t added to tree, else child added to tree (to
     * first element of tree, @param this.root).
     * @param child - child that is added to first element of tree (root).
     * @param root  - first element of tree.
     * @return returns true if child added to tree or returns false if child isn`t to tree.
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
     * addChildToParent - adds new child to parent if parent is in tree and child isn`t duplicate in tree.
     * @param parent - is parent (is generic type <E>).
     * @param child  - child that is added to parent (is generic type <E>).
     * @param root   - first element of tree.
     * @return returns true if child added to tree or returns false if child isn`t to tree.
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
     * get - searches entered parent and if parent is element of tree returns list children.
     * if entered parent isn`t element of tree return null.
     * @param parent - is parent (is generic type <E>).
     * @return returns list children if entered parent is element of tree.
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
     * getChildrenToParent - searches entered parent and if parent is element of tree returns list children.
     * if entered parent isn`t element of tree return null.
     * @param parent - is parent (is generic type <E>).
     * @param root   - is first element in tree (root).
     * @return returns list children if entered parent is element of tree.
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
    }

    /**
     * size - returns numbers of elements in tree.
     * @return returns numbers of elements in tree.
     */
    @Override
    public int size() {
        return this.size;
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
         * toString - returns string format.
         * @return all information for element of tree.
         */
        @Override
        public String toString() {
            return String.format("%s", this.value);
        }
    }
}
