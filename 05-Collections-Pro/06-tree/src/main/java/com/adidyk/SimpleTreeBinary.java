package com.adidyk;

/**
 * Interface SimpleTreeBinary for create elementary structure Tree-binary.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.10.2017.
 * @version 1.0.
 * @param <E> the type element of container for structure Tree-binary.
 */
interface SimpleTreeBinary<E extends Comparable<E>> extends Iterable<E> {

    /**
     * add - adds new element to Tree-binary.
     * @param node - is generic type <E>.
     * @return true or false.
     */
    boolean add(E node);


}
