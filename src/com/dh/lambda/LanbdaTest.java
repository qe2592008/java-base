package com.dh.lambda;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class LanbdaTest {
    public static String getName(Supplier<String> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        Person person = new Person("huahua");
        System.out.println(getName(person::getName));
        List<String> list = Collections.EMPTY_LIST;
        list.forEach(System.out::println);
        Map<String,Object> map = Collections.EMPTY_MAP;
        map.forEach((k,v) -> System.out.println(k + ":"+ v));


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("采用匿名内部类");
            }
        });

        Thread t1 = new Thread(()->System.out.println("采用Lambda方式"));
    }
}

class Person{
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}