package com.adidyk;

import java.util.Comparator;

/**
 * Class OrderSellComparator sorts sell-order by price increase.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 21.07.2017.
 * @version 1.0.
 */
public class OrderSellComparator implements Comparator<Double> {

    /**
     * compare - compares two object.
     * @param obj2 - order too.
     * @return - returns -1 or 1.
     */
    @Override
    public int compare(Double obj1, Double obj2) {
        return obj1.compareTo(obj2);
    }

}