package com.dh.concurrent.thread;

/**
 * wait和notify/notifyAll方法都是在Object类中定义的，那么每个类都可以使用这三个方法
 */
public class WaitNotifyTest {

    private static int flag = 0;
    private static Object lock = new Object();
    private volatile static int num = 0;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (lock) {
                while (flag == 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "-----等着吧");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "------" + ++num);
            }
        };
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + "----睡一会吧");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "----醒过来了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = 1;
                System.out.println(flag);
                lock.notifyAll();
            }
        });
        for (int i = 0;i < 10;i++) {
            Thread t = new Thread(runnable);
            t.setName("THREAD--" + i);
            t.start();
        }
        t2.setName("CHARGER--");
        t2.start();
    }

}
