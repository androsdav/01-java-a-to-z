package com.adidyk;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Bla bla bla. Bla, bla bla, bla.
 * Bla bla bla.
 */
public class UserTest {

    /**
     *
     */
    private final User user = new User("Bob", 3, new GregorianCalendar(1999, 9, 8));

    /**
     * @throws Exception 1
     */
    @Test
    public void setNameTest() throws Exception {
        this.user.setName("Bill");
        assertThat("Bill", is(this.user.getNAme()));
    }

    /**
     * @throws Exception 1
     */
    @Test
    public void setChildrenTest() throws Exception {
        this.user.setChildren(6);
        assertThat(6, is(this.user.getChildren()));
    }

    /**
     * @throws Exception 1
     */
    @Test
    public void setBirthdayTest() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        this.user.setBirthday(new GregorianCalendar(2000, 7, 3));
        assertThat("03.08.2000", is(sdf.format(this.user.getBirthday().getTime())));
    }

    /**
     * @throws Exception 1
     */
    @Test
    public void getNameTest() throws Exception {
        assertThat("Bob", is(this.user.getNAme()));
    }

    /**
     * @throws Exception 1
     */
    @Test
    public void getChildrenTest() throws Exception {
        assertThat(3, is(this.user.getChildren()));
    }

    /**
     * @throws Exception 1
     */
    @Test
    public void getBirthdayTest() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        assertThat("08.10.1999", is(sdf.format(this.user.getBirthday().getTime())));
    }

}