package com.adidyk;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetArrayTest {

    private SimpleSetArray<User> set = new SimpleSetArray<>();

    @Before
    public void init() {
        this.set.add(new User("0","Bob",10));
        this.set.add(new User("2","Bill",11));
        this.set.add(new User("3","Will",12));
        this.set.add(new User("4","Zeal",13));
}
    @Test
    public void addTestTrue() {
        boolean addTrue = this.set.add(new User("5", "Dilan", 14));
        assertThat(true, is(addTrue));
    }

    @Test
    public void addTestFalse(){
        boolean addFalse = this.set.add(new User("3", "Will", 12));
        assertThat(true, is(addFalse));

    }

}