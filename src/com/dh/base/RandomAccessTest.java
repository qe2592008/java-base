package com.dh.base;

import java.util.*;

public class RandomAccessTest {

    private List<String> list = null;

    public RandomAccessTest(List<String> list){
        this.list = list;
    }

    public void loop(){
        if(list instanceof RandomAccess) {
            // for循环
            System.out.println("采用for循环遍历");
            for (int i = 0;i< list.size();i++) {
                System.out.println(list.get(i));
            }
        } else {
            // 迭代器
            System.out.println("采用迭代器遍历");
            Iterator it = list.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("123","456","789","1110");
        List<String> list1 = new LinkedList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        new RandomAccessTest(list).loop();
        new RandomAccessTest(list1).loop();
        Spliterator sit = list.spliterator();
        sit.forEachRemaining(t ->System.out.println(t));
    }
}
