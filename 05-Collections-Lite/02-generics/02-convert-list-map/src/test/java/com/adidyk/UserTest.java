package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    private final User user = new User(1, "Tom", "New-York");

    @Test
    public void setIdTest() {
        Integer idActual = 2;
        this.user.setId(2);
        Integer idExpected = this.user.getId();
        assertThat(idActual, is(idExpected));
    }

    @Test
    public void setNameTest() {
        String nameActual = "Bill";
        this.user.setName("Bill");
        String nameExpected = this.user.getName();
        assertThat(nameActual, is(nameExpected));
    }

    @Test
    public void setCityTest() {
        String nameActual = "Chicago";
        this.user.setCity("Chicago");
        String cityExpected = this.user.getCity();
        assertThat(nameActual, is(cityExpected));
    }

    @Test
    public void getIdTest() {
        Integer idActual = 1;
        Integer idExpected = this.user.getId();
        assertThat(idActual, is(idExpected));
    }

    @Test
    public void getNameTest() {
        String nameActual = "Tom";
        String nameExpected = this.user.getName();
        assertThat(nameActual, is(nameExpected));
    }

    @Test
    public void getCity() {
        String cityActual = "New-York";
        String cityExpected = this.user.getCity();
        assertThat(cityActual, is(cityExpected));
    }

}
