package com.adidyk;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    private Set<User> userActual = new TreeSet<>();
    private List<User> user = new ArrayList<>();
    private SortUser sort = new SortUser();

    @Before
    public void init() {
        this.userActual.add(new User("Smith", 5));
        this.userActual.add(new User("Will", 10));
        this.userActual.add(new User("Bob", 15));
        this.userActual.add(new User("Antony", 32));
        this.userActual.add(new User("Andrey", 55));
        this.userActual.add(new User("Bill", 105));
        this.user.add(new User("Bill", 105));
        this.user.add(new User("Antony", 32));
        this.user.add(new User("Will", 10));
        this.user.add(new User("Andrey", 55));
        this.user.add(new User("Bob", 15));
        this.user.add(new User("Smith", 5));
    }

    @Test
    public void sortAddUserByFor() throws Exception {
        Set<User> userExpected = this.sort.sortAddUserByFor(this.user);
        assertThat(this.userActual, is(userExpected));

    }

    @Test
    public void sortAddUserByAddAll() throws Exception {
        Set<User> userExpected = this.sort.sortAddUserByAddAll(this.user);
        assertThat(this.userActual, is(userExpected));

    }

    @Test
    public void sortAddUserByConstructor() throws Exception {
        Set<User> userExpected = this.sort.sortAddUserByConstructor(this.user);
        assertThat(this.userActual, is(userExpected));
    }

}