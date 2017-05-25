package com.adidyk;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    private List<User> users = new ArrayList<>();
    private Set<User> userSetActual = new TreeSet<>();
    private List<User> userHashActual = new ArrayList<>();
    private List<User> userLengthActual = new ArrayList<>();
    private SortUser sorting = new SortUser();

    @Before
    public void init() {
        this.users.add(new User("Albert", 17));
        this.users.add(new User("Carl", 45));
        this.users.add(new User("Daniel", 16));
        this.users.add(new User("Leonard", 102));
        this.users.add(new User("Melvin", 54));
        this.users.add(new User("Christopher", 33));
        this.users.add(new User("David", 23));
        this.users.add(new User("Brandon", 78));
        this.userSetActual.addAll(this.users);
        this.userHashActual.addAll(this.users);
        Collections.sort(this.userHashActual, new UserHashCodeComparator());
        this.userLengthActual.addAll(this.users);
        Collections.sort(this.userLengthActual, new UserNameByLengthComparator());

    }

    @Test
    public void sortAddUserByConstructor() throws Exception {
        Set<User> userExpected = this.sorting.sortAddUserByConstructor(this.users);
        assertThat(this.userSetActual, is(userExpected));
    }

    @Test
    public void sortHashTest() {
        List<User> userExpected = this.sorting.sortHash(this.users);
        assertThat(this.userHashActual, is(userExpected));
    }

    @Test

    public void sortLength() {
        List<User> userExpected = this.sorting.sortLength(this.users);
        assertThat(this.userLengthActual, is(userExpected));
    }

}