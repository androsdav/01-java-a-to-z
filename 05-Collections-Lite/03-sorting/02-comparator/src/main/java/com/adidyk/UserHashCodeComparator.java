package com.adidyk;

import java.util.Comparator;

public class UserHashCodeComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.hashCode() > o2.hashCode())
            return 1;
        else if (o1.hashCode() < o2.hashCode())
            return -1;
        else
            return 0;
    }

}
