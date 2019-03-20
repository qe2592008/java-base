package com.dh.concurrent.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private final static Lock lock = new ReentrantLock();
    public static void main(String[] args) {

        lock.lock();
        try {
            System.out.println("sss");
            LockSupport.park();
            System.out.println("bbb");
//            test();
        }finally {
            lock.unlock();
        }
    }

    private static void test(){
        lock.lock();
        try {
            System.out.println("aaa");
        }finally {
            lock.unlock();
        }
    }

}
