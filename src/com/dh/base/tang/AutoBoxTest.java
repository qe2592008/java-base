package com.dh.base.tang;

public class AutoBoxTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 128;
        Integer f = 128;
        Long g = 3l;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(e.equals(f));
        System.out.println(c== (a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
    }
}
