package com.adidyk;

import java.util.Comparator;

/**
 * Class User for create user (object) with params: name, children and birthday.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class OrderBuyComparator implements Comparator<Double> {

    /**
     *
     * @param o1 is order one.
     * @param o2 is order too.
     * @return result.
     */
    @Override
    public int compare(Double o1, Double o2) {
        return o2.compareTo(o1);
    }
}
