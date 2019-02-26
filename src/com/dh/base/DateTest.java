package com.dh.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
    public static void main(String[] args) {
        Date date1 = new Date(0);// 格林威治1970年1月1日0点0分0秒
        System.out.println("格林威治0时的时间戳：" + date1.getTime());
        System.out.println("格林威治0时的中国时区时间：" + date1);
        Date date2 = new Date();// 当前时间戳
        System.out.println("date2的时间戳：" + date2.getTime());
        System.out.println("date2表示的中国时区时间:" + date2);
        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));// 设置时区为美国洛杉矶时区
        System.out.println("date2表示的美国洛杉矶时区时间：" + date2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));// 设置为美国纽约时区
        System.out.println("date2表示的美国纽约时区时间：" + sdf.format(date2));
    }
}
