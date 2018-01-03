package com.adidyk;

import java.util.Comparator;

/**
 * Class OrderBuyComparator sorts buy-order by price reduction.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class OrderBuyComparator implements Comparator<Double> {

    /**
     * compare - compares two object.
     * @param obj1 - is order one.
     * @param obj2 - is order too.
     * @return - returns -1 or 1.
     */
    @Override
    public int compare(Double obj1, Double obj2) {
        return obj2.compareTo(obj1);
    }

}