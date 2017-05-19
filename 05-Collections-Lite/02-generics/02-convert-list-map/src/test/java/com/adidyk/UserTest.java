package com.adidyk;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    private final User user = new User(1, "Tom", "New-York");

//    List<User> list = new ArrayList<>();
  //  list.add(new User(1, "Tom", "New-York"));
  //  list.add(new User(2, "Bill", "Atlanta"));
//    list.add(new User(3, "Kelly", "Santa-Barbara"));
//    list.add(new User(4, "Brook", "Chicago"));
//    list.add(new User(5, "Bolt", "Dallas"));
    @Test
    public void getId() {
        Integer idActual = 1;
        Integer idExpected = this.user.getId();
        assertThat(idActual, is(idExpected));
    }

    @Test
    public void getName() {
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
