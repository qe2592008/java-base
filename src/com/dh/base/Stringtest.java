package com.dh.base;

public class Stringtest {
    public static void main(String[] args) {
        String s = "1234567890123";
        System.out.println(s.replace('1','a'));
        System.out.println(s.replace("123","abc"));
        System.out.println(s.replaceFirst("1","xxxxxxx"));
        System.out.println(s.replaceAll("12","xxxxxxx"));
        System.out.println(s.replaceAll("\\d","a"));

        System.out.println("----------------");

        String s1 = new String("123321");
        String s2 = new String("123321");
        System.out.println(s1==s2);
        s1 = s1.intern();
        System.out.println(s1==s2);
        s2 = s2.intern();
        System.out.println(s1==s2);
        String s3 = "123321";
        System.out.println(s2==s3);
    }
}
