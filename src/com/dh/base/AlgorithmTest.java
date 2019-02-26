package com.dh.base;

public class AlgorithmTest {
    public static void main(String[] args) {
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

