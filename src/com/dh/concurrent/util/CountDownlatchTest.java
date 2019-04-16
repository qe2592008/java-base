package com.dh.concurrent.util;

import java.util.concurrent.CountDownLatch;

public class CountDownlatchTest {

    public static void main1(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        for(int i = 0;i < 10;i++){
            new Thread(()->{
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ooOp");
            }).start();
        }
        Thread.sleep(3000);
        System.out.println("mamap");
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0;i<9;i++) {
            new Thread(()->{
                latch.countDown();
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("内部线程");
            }).start();
        }
        Thread.sleep(3000);
        latch.countDown();
    }
}
