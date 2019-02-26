package com.dh.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class SimpleDateFormatTest {

    public static ThreadLocal<SimpleDateFormat> sdfThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmss");
        }
    };

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Calendar c = Calendar.getInstance();

//    public static HashSet<String> set = new HashSet<>(100);
    static Set<String> dates = Collections.synchronizedSet(new HashSet<String>());

    private static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws ParseException, InterruptedException {
        for (int i = 0; i < 100; i++){
            new Thread(()->{
                c.add(Calendar.DATE,1);
                dates.add(sdfThreadLocal.get().format(c.getTime()));
                System.out.println(dates.size());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("最后"+dates.size());
    }

//    public static void test1() throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        // 格式化-将Date格式化输出
//        Date date = new Date();
//        System.out.println(sdf.format(date));
//        // 解析-将String解析为Date
//        String dateStr = "2019-01-01 12:12:12";
//        System.out.println(sdf.parse(dateStr));
//    }
}