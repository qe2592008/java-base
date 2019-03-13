package com.dh.concurrent.thread;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread t1 = new Thread(new MyThread1());
        t1.start();
        FutureTask task = new FutureTask(new MyThread2());
        Thread t2 = new Thread(task);
        t2.start();


        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "通过Callable创建线程";
            }
        };
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(callable);
        future.get();
        Executor executor = new ThreadPoolExecutor(2,3,1L,TimeUnit.SECONDS,new ArrayBlockingQueue(10));

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("通过继承Thread创建线程");
    }
}

class MyThread1 implements Runnable {

    @Override
    public void run() {
        System.out.println("通过实现Runnable创建线程");
    }
}

class MyThread2 implements Callable {
    @Override
    public Object call() throws Exception {
        return "通过Callable创建线程";
    }
}
