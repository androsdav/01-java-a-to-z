package com.adidyk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void processTest() {
        Map<Integer, User> mapUserActual = new HashMap<>();
        mapUserActual.put(1, new User(1, "Tom", "New-York"));
        mapUserActual.put(2, new User(2, "Bill", "Atlanta"));
        mapUserActual.put(3, new User(3, "Kelly", "Santa-Barbara"));
        mapUserActual.put(4, new User(4, "Brook", "Chicago"));
        mapUserActual.put(5, new User(5, "Bolt", "Dallas"));

        List<User> list = new ArrayList<>();
        list.add(new User(1, "Tom", "New-York"));
        list.add(new User(2, "Bill", "Atlanta"));
        list.add(new User(3, "Kelly", "Santa-Barbara"));
        list.add(new User(4, "Brook", "Chicago"));
        list.add(new User(5, "Bolt", "Dallas"));
        UserConvert user = new UserConvert();
        Map<Integer, User> mapUserExpected = user.process(list);
        assertThat(mapUserActual, is(mapUserExpected));
    }
}
