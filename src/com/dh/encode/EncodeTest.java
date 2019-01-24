package com.dh.encode;

import java.io.UnsupportedEncodingException;

public class EncodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "老马";
        System.out.println(s.getBytes("GB18030"));
        String ns = new String(s.getBytes("ISO-8859-1"),"GB18030");
        System.out.println(ns);
    }
}
