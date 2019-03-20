package com.dh.concurrent.threadLocal;

public class ThreadLocalObject {
    public static final ThreadLocal<String> local1 = new ThreadLocal<>();
    public static final ThreadLocal<String> local2 = new ThreadLocal<>();

    public static void setLocal1(String value){
        local1.set(value);
    }
    public static void setLocal2(String value){
        local2.set(value);
    }
    public static String getLocal1(){
        return local1.get();
    }
    public static String getLocal2(){
        return local2.get();
    }
}
