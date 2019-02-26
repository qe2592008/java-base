package com.dh.collection;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("123","444444","2123"));
        ListIterator<String> listIterator = list.listIterator();
        ListIterator<String> listIterator1 = list.listIterator(1);
        Iterator<String> iterator = list.iterator();
        Spliterator<String> spliterator = list.spliterator();
        listIterator.forEachRemaining(System.out::println);
        System.out.println("-------------");
        listIterator1.forEachRemaining(System.out::println);
        System.out.println("-------------");
        iterator.forEachRemaining(System.out::println);
        System.out.println("-------------");
        spliterator.forEachRemaining(System.out::println);
        System.out.println("-------------");
        list.forEach(System.out::println);
        List<String> list2 = (ArrayList<String>)((ArrayList<String>) list).clone();
        list2.forEach(System.out::println);

    }

}
