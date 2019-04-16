package com.dh.base;

public class AlgorithmTest {
    public static void main(String[] args) {
        System.out.println(1/2);
        Integer i = 1;
        int j = 1;
        test(i);
        test(j);
    }

    public static void test(int j){
        System.out.println("int");
    }
    public static void test(Integer j){
        System.out.println("Integer");
    }
}

