package com.adidyk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest does testing of class Counter.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 24.01.2018.
 * @version 1.0.
 */
public class UserTest {

    /**
     * @param first - is first user.
     */
    private final User first = new User(10, 1000);

    /**
     * @param second - is second user.
     */
    private final User second = new User(11, 2000);

    /**
     * setIdTest - tests method setId class User.
     */
    @Test
    public void setIdTest() {
        this.first.setId(9);
        assertThat(9, is(this.first.getId()));
    }

    /**
     * setAmountTest - tests method setId class User.
     */
    @Test
    public void addAmountTest() {
        this.first.addAmount(12);
        assertThat(1012, is(this.first.getAmount()));
    }

    /**
     * subAmountTest - tests method subAmount class User.
     */
    @Test
    public void subAmountTest() {
        this.first.subAmount(500);
        assertThat(500, is(this.first.getAmount()));
    }

    /**
     * getIdTest - tests method setId class User.
     */
    @Test
    public void getIdTest() {
        this.first.setId(11);
        assertThat(this.first, is(this.second));
    }

    /**
     * getAmountTest - tests method setId class User.
     */
    @Test
    public void getAmountTest() {
        assertThat(2000, is(this.second.getAmount()));
    }

}