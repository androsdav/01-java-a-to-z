package com.adidyk;

import java.util.Comparator;
import java.util.Map;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class OrderComparator implements Comparator<Order> {

    /**
     *
     * @param o1 is order one.
     * @param o2 is order too.
     * @return result.
     */
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
