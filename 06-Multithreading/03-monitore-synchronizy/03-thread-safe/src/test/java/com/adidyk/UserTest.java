package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class UserTest does testing of class User.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 17.02.2018.
 * @version 1.0.
 */
public class UserTest {

    /**
     * @param girl - is object of class user.
     */
    private final User girl = new User("111", "Matilda", 18);


    /**
     * setNameTest - tests method setName class User.
     * @throws Exception - exception.
     */
    @Test
    public void setNameTest() throws Exception {
        this.girl.setName("Lola");
        this.girl.setName("Lolita");
        assertThat(new User("111", "Lolita", 18), is(this.girl));
    }

    /**
     * setAgeTest - tests method setAge class User.
     * @throws Exception - exception.
     */
    @Test
    public void setAgeTest() throws Exception {
        this.girl.setAge(55);
        this.girl.setAge(123);
        assertThat(new User("111", "Matilda", 123), is(this.girl));
    }

    /**
     * setIdTest - tests method setId class User.
     * @throws Exception - exception.
     */
    @Test
    public void getIdTest() throws Exception {
        assertThat("111", is(this.girl.getId()));
    }

    /**
     * getNameTest - tests method getName class User.
     * @throws Exception - exception.
     */
    @Test
    public void getNameTest() throws Exception {
        assertThat("Matilda", is(this.girl.getName()));
    }

    /**
     * getAgeTest - tests method getAge class User.
     * @throws Exception - exception.
     */
    @Test
    public void getAgeTest() throws Exception {
        assertThat(18, is(this.girl.getAge()));
    }

}