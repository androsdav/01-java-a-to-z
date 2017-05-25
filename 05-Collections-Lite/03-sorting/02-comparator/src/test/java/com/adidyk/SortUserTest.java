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

    private List<User> userListActual = new ArrayList<>();
    private Set<User> userSetActual = new TreeSet<>();
    private List<User> users = new ArrayList<>();

    //private Set<User> userActual = new TreeSet<>();
    //private List<User> user = new ArrayList<>();
    private SortUser sorting = new SortUser();

    @Before
    public void init() {
        this.userListActual.add(new User("Albert", 17));
        this.userListActual.add(new User("Carl", 45));
        this.userListActual.add(new User("Daniel", 16));
        this.userListActual.add(new User("Leonard", 102));
        this.userListActual.add(new User("Melvin", 54));
        this.userListActual.add(new User("Christopher", 33));
        this.userListActual.add(new User("David", 23));
        this.userListActual.add(new User("Brandon", 78));
        this.userSetActual.addAll(this.userListActual);
        this.users.addAll(this.userListActual);

        System.out.println("userListActual");
        for (User user : this.userListActual) {
            System.out.println(user);
        }

        System.out.println("userSetActual");
        for (User user : this.userSetActual) {
            System.out.println(user);
        }

        System.out.println("usersList");
        for (User user : this.users) {
            System.out.println(user);
        }

        System.out.println("Test test");

    }


    /*

    this.userActual.add(new User("Smith", 5));
    this.userActual.add(new User("Will", 10));
    this.userActual.add(new User("Bob", 15));
    this.userActual.add(new User("Antony", 32));
    this.userActual.add(new User("Andrey", 55));
    this.userActual.add(new User("Bill", 105));
    this.user.addAll(new User("Bill", 105), );
    this.user.add(new User("Antony", 32));
    this.user.add(new User("Will", 10));
    this.user.add(new User("Andrey", 55));
    this.user.add(new User("Bob", 15));
    this.user.add(new User("Smith", 5));
}
*/
    @Test
    public void sortAddUserByFor() throws Exception {
        Set<User> userExpected = this.sorting.sortAddUserByFor(this.users);
        assertThat(this.userSetActual, is(userExpected));
    }



    @Test
    public void sortAddUserByAddAll() throws Exception {
        Set<User> userExpected = this.sorting.sortAddUserByAddAll(this.users);
        assertThat(this.userSetActual, is(userExpected));

    }

    @Test
    public void sortAddUserByConstructor() throws Exception {
        Set<User> userExpected = this.sorting.sortAddUserByConstructor(this.user);
        assertThat(this.userActual, is(userExpected));
    }

    @Test
    public void sortHashTest() {
        S
    }

}*/
}