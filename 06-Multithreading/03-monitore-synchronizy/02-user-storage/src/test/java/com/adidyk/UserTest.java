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
     * @param user - is user.
     */
    private final User user = new User(135, 12345);

    /**
     * setIdTest - tests method setId class User.
     */
    @Test
    public void setIdTest() {
        this.user.setId(123);
        assertThat(123, is(this.user.getId()));
    }

    /**
     * setAmountTest - tests method setId class User.
     */
    @Test
    public void addAmountTest() {
        this.user.addAmount(54321);
        assertThat(54321, is(this.user.getAmount()));
    }

    /**
     * getIdTest - tests method setId class User.
     */
    @Test
    public void getIdTest() {
        assertThat(135, is(this.user.getId()));
    }

    /**
     * getAmountTest - tests method setId class User.
     */
    @Test
    public void getAmountTest() {
        assertThat(12345, is(this.user.getAmount()));
    }

}