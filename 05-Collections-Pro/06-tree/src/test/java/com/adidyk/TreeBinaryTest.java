package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TreeBinaryTest for testing methods class TreeBinary.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.10.2017.
 * @version 1.0.
 */
public class TreeBinaryTest {

    /**
     * @param tree - reference variable to object of class TreeBinary.
     */
    private TreeBinary<Integer> tree = new TreeBinary<>();

    /**
     * @param it - is iterator.
     */
    private Iterator it;

    /**
     * init - adds new object to tree-binary and initialisation iterator.
     */
    @Before
    public void init() {
        this.tree.add(10);
        this.tree.add(12);
        this.tree.add(5);
        this.tree.add(11);
        this.tree.add(13);
        this.tree.add(15);
        this.it = this.tree.iterator();
    }

    /**
     * addTest - tests method add(E value) of class TreeBinary.
     */
    @Test
    public void addTest() {
        ArrayList<Integer> listActual = new ArrayList<>(Arrays.asList(10, 5, 12, 11, 13, 15));
        int index = 0;
        while (this.it.hasNext()) {
            assertThat(this.it.next(), is(listActual.get(index++)));
        }
    }

    /**
     * hasNextTrue - tests method hasNext() of class TreeBinary when next element is in tree-binary.
     */
    @Test
    public void hasNextTrue() {
        this.it.next();
        this.it.next();
        this.it.hasNext();
        assertThat(true, is(this.it.hasNext()));
    }

    /**
     * hasNextFalse - test method hasNext() of class treeBinary when next element isn`t in tree-binary.
     */
    @Test
    public void hasNextFalse() {
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        this.it.next();
        assertThat(false, is(this.it.hasNext()));
    }

}