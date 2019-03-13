package com.dh.concurrent.thread;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for(int i = 0;i<1000000 && !Thread.interrupted();i++){
                System.out.println(i);
            }
        });

        t.start();
        Thread.sleep(100);
        t.interrupt();
    }
}
