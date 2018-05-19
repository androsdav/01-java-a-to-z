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
     * @param user - link variable to object of class User.
     */
    private final User user = new User(1, "Bill", "operator");

    /**
     * setRoleTest - tests method setRole of class User.
     */
    @Test
    public void serRoleTest() {
        this.user.setRole("administrator");
        assertThat("administrator", is(this.user.getRole()));
    }

    /**
     * setVersionTest - tests method setVersion of class User.
     */
    @Test
    public void setVersionTest() {
        this.user.setVersion(1);
        assertThat(1, is(this.user.getVersion()));
    }

    /**
     * getIdTest - tests method getId of class User.
     */
    @Test
    public void getIdTest() {
        assertThat(1, is(this.user.getId()));
    }

    /**
     * getNameTest - tests method getName of class User.
     */
    @Test
    public void getNameTest() {
        assertThat("Bill", is(this.user.getName()));
    }

    /**
     * getRoleTest - tests method getRole of class User.
     */
    @Test
    public void getRoleTest() {
        assertThat("operator", is(this.user.getRole()));
    }

    /**
     * getVersionTest - tests method getVersion of class User.
     */
    @Test
    public void getVersionTest() {
        assertThat(0, is(this.user.getVersion()));
    }

}