package com.dh.base;

import java.util.ArrayDeque;

public class BinaryTest {
    public static void main1(String[] args) {
        int i = -1;
        System.out.println(Integer.toBinaryString((0-1)&(8-1)));
        ArrayDeque<String> deque = new ArrayDeque<>(7);
//        deque.addFirst("1111");
        deque.add("2222");

    }
    public static void main(String[] args) {
        System.out.println(111);
        ArrayDeque<String> dd = new ArrayDeque<>();
        for(int i = 1;i<16 ;i++){
            dd.add(i+"");
        }
        dd.add("over");

    }
}
