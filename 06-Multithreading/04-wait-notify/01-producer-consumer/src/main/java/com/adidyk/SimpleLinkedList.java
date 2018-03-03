package com.adidyk;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Iterator;

/**
 * SimpleLinkedList is container based on an linked list (dynamic container). Each element in
 * container contains object Node. Object of class Node has next  parameters:
 * -> prev  - link on previous object of class Node;
 * -> value - value its generic type <E>;
 * -> next  - link on next object of class Node.
 * @param <E> - is type objects (generic).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
@ThreadSafe
public class SimpleLinkedList<E> implements SimpleList<E> {

    /**
     * @param first - is first element in container.
     */
    @GuardedBy("this")
    private Node<E> first;

    /**
     * @param last - is last element in container.
     */
    @GuardedBy("this")
    private Node<E> last;

    /**
     * @param size - is number of element in container.
     */
    @GuardedBy("this")
    private int size;

    /**
     * @param modCount - counter of number modification.
     */
    private int modCount = 0;

    /**
     * add - adds object to container.
     * @param object - is object.
     */
    public synchronized void add(E object) {
        final Node<E> oldNode = this.last;
        final Node<E> newNode = new Node<>(oldNode, object, null);
        this.last = newNode;
        if (oldNode == null) {
            this.first = newNode;
        } else {
            oldNode.next = newNode;
        }
        this.size++;
        this.modCount++;
    }

    /**
     * get - returns object from container by index.
     * @param index - index in the container for which the object is returned from the cell.
     * @return - returns object from container by index.
     */
    public synchronized E get(int index) {
        this.checkPositionIndex(index);
        Node<E> object = this.first;
        for (int position = 0; position < index; position++) {
            object = object.next;
        }
       return object.value;
    }

    /**
     * getFirst - returns first object from container.
     * @return - returns first object from container.
     */
    synchronized E getFirst() {
        final Node<E> object = this.first;
        if (object == null) {
            throw new HasNotFirstElementException("Has not first element ... ");
        }
        return object.value;
    }

    /**
     * getLast - returns last object from container.
     * @return - returns last object from container.
     */
    synchronized E getLast() {
        final Node<E> object = this.last;
        if (object == null) {
            throw new HasNotLastElementException("Has not last element ...");
        }
        return object.value;
    }

    /**
     * size - returns number of object in container.
     * @return - returns number of object in container.
     */
    synchronized int size() {
        return this.size;
    }

    /**
     * outOfBoundMsg - returns information about exception.
     * @param index - index in the container for which the object is returned from the cell.
     * @return - returns information about exception.
     */
    private synchronized String outOfBoundMsg(int index) {
        return "Index: " + index + "; " + "range of indexes: [" + "0-" + (this.size - 1) + "]";
    }

    /**
     * cheackPositionIndex - checks position index.
     * @param index - index in the container for which the object is returned from the cell.
     */
    private synchronized void checkPositionIndex(int index) {
        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException(this.outOfBoundMsg(index));
        }
    }

    /**
     * equals - return boolean result.
     * @param obj - object of class User.
     * @return - returns boolean result "true" if container is same, and returns "false" - isn`t same.
     */
    @Override
    public synchronized boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleLinkedList)) {
            return false;
        }
        SimpleLinkedList<?> that = (SimpleLinkedList<?>) obj;
        if (size != that.size) {
            return false;
        }
        if (!getFirst().equals(that.getFirst())) {
            return false;
        }
        return getLast().equals(that.getLast());
    }

    /**
     * hashCode - returns hashCode for container.
     * @return - returns hashcode for container.
     */
    @Override
    public synchronized int hashCode() {
        int result = getFirst().hashCode();
        result = 31 * result + getLast().hashCode();
        result = 31 * result + size;
        return result;
    }

    /**
     * toString - returns string format.
     * @return - returns all information in string format.
     */
    @Override
    public synchronized String toString() {
        return String.format(" %s%s%s%s%s%s%s%s",
                "SimpleLinkedList{", "first =", this.first.value, "; last =", this.last.value, "}", " size=", this.size);
    }

    /**
     * iterator - returns new iterator for container.
     * @return - returns new iterator for container.
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new SimpleIterator(this.first, this.size, this.modCount);
    }

    /**
     * SimpleIterator class iterator.
     */
    @ThreadSafe
    private class SimpleIterator implements Iterator<E> {

        /**
         * @param object - is first element in container (linked list).
         */
        @GuardedBy("this")
        private Node<E> object;

        /**
         * @param result - is returned element by iterator.
         */
        @GuardedBy("this")
        private E result;

        /**
         * @param size - is number of element in container (linked list).
         */
        @GuardedBy("this")
        private int size;

        /**
         * @param index - is index.
         */
        @GuardedBy("this")
        private int index;

        /**
         * @param expectedModCount - expected number of modification.
         */
        @GuardedBy("this")
        private int expectedModCount;

        /**
         * SimpleIterator - constructor.
         * @param first - is first element in container (linked list).
         * @param size - is number of element in container (linked list).
         * @param expectedModCount - expected number of modification.
         */
        SimpleIterator(Node<E> first, int size, int expectedModCount) {
            this.object = first;
            this.size = size;
            this.expectedModCount = expectedModCount;
        }

        /**
         * hasNext - returns true if next element is in container or returns false if next element isn`t in container.
         * @return - returns true if next element is in container or returns false if next element isn`t in container.
         */
        @Override
        public synchronized boolean hasNext() {
            return (this.index < this.size);
        }

        /**
         * next - returns next element from collection.
         * @return - returns next element from collection.
         */
        @Override
        public synchronized E next() {
            if (this.expectedModCount == modCount) {
                this.result = this.object.value;
                this.object = this.object.next;
                this.index++;
            } else {
                throw new ConcurrentModificationException("ConcurrentModificationException");
            }
            return this.result;
        }

        /**
         * remove - isn`t nothing.
         */
        @Override
        public void remove() {
        }

    }

   /**
    * Node class using for created object of class Node in container (linked list). Object of class Node
    * has next parameters:
    * -> prev  - link on previous object of class Node;
    * -> value - value its generic type <E>;
    * -> next  - link on next object of class Node.
    * @param <E> - is type objects (generic).
   */
   @ThreadSafe
   private static class Node<E> {

        /**
        * @param prev - link on previous object of class Node.
        */
        private Node<E> prev;

        /**
        * @param value - value its generic type <E>.
        */
        private E value;

        /**
        * @param next - link on next object of class Node.
        */
        private Node<E> next;

        /**
        * Node - constructor.
        * @param prev - link on previous object of class Node.
        * @param value - value its generic type <E>.
        * @param next - link on next object of class Node.
        */
        Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

   }

}