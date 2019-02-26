package com.dh.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("123","45612","7839"));
        list.sort((o1, o2) -> o1.length()-o2.length());
        list.forEach(System.out::println);
    }
}
