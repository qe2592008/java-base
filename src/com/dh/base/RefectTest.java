package com.dh.base;

public class RefectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = "".getClass();
        Class c2 = String.class;
        Class c3 = Class.forName("java.lang.String");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
