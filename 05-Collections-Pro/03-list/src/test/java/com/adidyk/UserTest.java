package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    private final User girl = new User("111", "Matilda", 18);

    @Test
    public void setIdTest() throws Exception {
        this.girl.setId("222");
        assertThat(new User("222", "Matilda", 18), is(this.girl));
    }

    @Test
    public void setNameTest() throws Exception {
        this.girl.setName("Lola");
        assertThat(new User("111", "Lola", 18), is(this.girl));
    }

    @Test
    public void setAgeTest() throws Exception {
        this.girl.setAge(55);
        assertThat(new User("111", "Matilda", 55), is(this.girl));
    }

    @Test
    public void getIdTest() throws Exception {
        assertThat("111", is(this.girl.getId()));
    }

    @Test
    public void getNameTest() throws Exception {
        assertThat("Matilda", is(this.girl.getName()));
    }

    @Test
    public void getAge() throws Exception {
        assertThat(18, is(this.girl.getAge()));
    }

}