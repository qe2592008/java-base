package com.dh.collection;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> map1 = new LinkedHashMap<>(16,0.75f,false);
        LinkedHashMap<String, String> map2 = new LinkedHashMap<>(16,0.75f,true);
        map1.put("1","123");
        map1.put("2","456");
        map1.put("3","789");
        map2.put("1","123");
        map2.put("2","456");
        map2.put("3","789");
        map1.forEach((key, value)->{
            System.out.println(key + "-" + value);
        });
        map2.forEach((key, value)->{
            System.out.println(key + "-" + value);
        });
        System.out.println("--------------------------");
        System.out.println(map1.get("2"));
        System.out.println(map2.get("2"));
        System.out.println("--------------------------");
        map1.forEach((key, value)->{
            System.out.println(key + "-" + value);
        });
        map2.forEach((key, value)->{
            System.out.println(key + "-" + value);
        });

        LinkedHashSet<String> ss = new LinkedHashSet<>();
        ss.add("1");
    }

}
