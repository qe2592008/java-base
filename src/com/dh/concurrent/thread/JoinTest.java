package com.dh.concurrent.thread;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("zzzzzzzzzzzz");
        });

        Thread t = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("xxxxxxxxxxx");
        });
        t.setName("aaa");
        t2.setName("bbb");

        t.start();
        t2.start();
        t2.join();

        System.out.println("jixu");
        System.out.println("wanjie");
    }
}
