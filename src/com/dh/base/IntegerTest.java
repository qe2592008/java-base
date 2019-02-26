package com.dh.base;

public class IntegerTest {
    public static void main(String[] args) {
        Integer i = 100;// 经历装箱-使用缓存
        Integer j = 100;// 经历装箱-使用缓存
        Integer k = 128;// 经历装箱-不使用缓存
        Integer h = 128;// 经历装箱-不使用缓存
        int l = 100;// 数值
        int m = 100;// 数值
        int n = 128;// 数值
        Integer o = new Integer(100);// 堆中创建对象
        Integer p = new Integer(100);// 堆中创建对象
        Integer q = new Integer(128);// 堆中创建对象
        System.out.println(i==j);// true-经历装箱，使用缓存，所以一致
        System.out.println(l==m);// true-基本类型比较值，当然一致
        System.out.println(o==p);// false-分别在堆中创建，位置不同
        System.out.println(i==l);// true-需要进行拆箱，变成两个基本类型比较，当然一致
        System.out.println(k==n);// true-同上
        System.out.println(l==o);// true-同上
        System.out.println(n==q);// true-同上
        System.out.println(i==o);// false-一个经历装箱，使用缓存值，一个在堆中建立，位置不同
        System.out.println(k==h);// false-经历装箱，但无法使用缓存，位置不同
    }
}
