package com.dh.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericityTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<ArrayList> list = new ArrayList<>();
        List<Collection> c = new ArrayList<>();
        doSome(strings);
        doSome1(list);
        doSome2(c);
        doSome(list);
        doSome(c);
    }

    public static void doSome(List<?> ss){}
    public static void doSome1(List<? extends List> ss){}
    public static void doSome2(List<? super List> ss){}

}

class Test<T> {
    <E> void get(E e){}

}