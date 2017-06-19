package com.adidyk;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoleTest {

    private final Role role = new Role("123", "Bill");

    @Test
    public void setIdTest() throws Exception {
        this.role.setId("124");
        assertThat(new Role("124", "Bill"), is(this.role));
    }

    @Test
    public void setNameTEst() throws Exception {
        this.role.setName("Dragon");
        assertThat(new Role("123", "Dragon"), is(this.role));
    }

    @Test
    public void getIdTest() throws Exception {
        assertThat("123", is(this.role.getId()));
    }

    @Test
    public void getNameTest() throws Exception {
        assertThat("Bill", is(this.role.getName()));
    }

}