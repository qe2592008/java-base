package com.dh.concurrent.threadLocal;

public class ThreadLocalTest {
    public static void main(String[] args) {
        for (int i = 1;i<=100;i++) {
            String s1 = i +"";
            String s2 = i+"";
            new Thread(()->{
                ThreadLocalObject.setLocal1(s1);
                ThreadLocalObject.setLocal2(s2);
                System.out.println(ThreadLocalObject.getLocal1()+"---"+ThreadLocalObject.getLocal2());
            }).start();
        }
    }
}
