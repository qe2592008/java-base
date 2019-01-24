package com.dh.compare;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(12, "xiaohua");
        User u2 = new User(10, "abc");
        User u3 = new User(15,"ccc");
        User[] users = {u1,u2,u3};
        System.out.print("数组排序前：");
        printArray(users);
        System.out.println();
        Arrays.sort(users);
        System.out.print("数组排序1后：");
        printArray(users);
        System.out.println();
        Arrays.sort(users, new MyComparator());
        System.out.print("数组排序2后：");
        printArray(users);
        System.out.println();
        Arrays.sort(users, Comparator.reverseOrder());// 针对内置的排序进行倒置
        System.out.print("数组排序3后：");
        printArray(users);
    }

    public static void printArray (User[] users) {
        for (User user:users) {
            System.out.print(user.toString());
        }
    }
}
