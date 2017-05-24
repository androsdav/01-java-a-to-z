package com.adidyk;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    private final User user = new User("Tom", 110);

    @Test
    public void setNameTest() {
        String nameActual = "Bill";
        this.user.setName("Bill");
        String nameExpected = this.user.getName();
        assertThat(nameActual, is(nameExpected));
    }

    @Test
    public void setAgeTest() {
        int ageActual = 99;
        this.user.setAge(99);
        int ageExpected = this.user.getAge();
        assertThat(ageActual, is(ageExpected));
    }

    @Test
    public void getNameTest() {
        String nameActual = "Tom";
        String nameExpected = this.user.getName();
        assertThat(nameActual, is(nameExpected));
    }

    @Test
    public void getAge() {
        int ageActual = 110;
        int ageExpected = this.user.getAge();
        assertThat(ageActual, is(ageExpected));
    }

}