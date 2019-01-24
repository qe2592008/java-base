package com.dh.compare;

import java.util.Comparator;

public class MyComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().charAt(0)-o2.getName().charAt(0);
    }
}
