package com.dh.concurrent.thread;

public class RunnableTest {
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("1");
        }
    });
    Thread t2 = new Thread(()-> System.out.println("2"));
}
