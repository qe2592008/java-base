package com.dh.concurrent.thread;

public class ThreadLocalTest {

//    private static int j = 0;
//
//    private static final ThreadLocal local1 = new ThreadLocal();
//
//    private static final ThreadLocal local2 = new ThreadLocal();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1;i <= 100000;i++){
            new Thread(()->{
                Caozuo caozuo = new Caozuo();
                MyThreadLocal.local1.set(new Caozuo().zizeng());

                System.out.println(MyThreadLocal.local1.get());
            }).start();
        }
//        Thread.sleep(10000);
//        System.out.println(Caozuo.j);

    }

    private static void test(){
//        System.out.println(local1.get());
    }
}

class MyThreadLocal{
    static final ThreadLocal local1 = new ThreadLocal();
}

class Caozuo{
    private int j = 0;
    public int zizeng(){
        return ++j;
    }
}