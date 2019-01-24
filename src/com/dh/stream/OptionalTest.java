package com.dh.stream;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> o = Optional.empty();// 创建一个空Optional
        Optional<String> op = Optional.of("123");// 创建一个目标对象必须有值的Optional
        Optional<String> opt = Optional.ofNullable(null);// 创建一个目标对象可为null的Optional
        filterTest();
        mapTest();
        flatMapTest();
        getTest();
        orElseTest();
    }

    public static void getTest(){
        Optional<String> os = Optional.of("123456");
        System.out.println(os.get());
    }

    public static void orElseTest(){
        Optional<String> os = Optional.empty();
        System.out.println(os.orElse("default"));
        System.out.println(os.orElseGet(()->"default"));
        System.out.println(os.orElseThrow(RuntimeException::new));
    }

    public static void flatMapTest(){
        Optional<Person> op = Optional.of(new Person("huahua"));
        Optional<Optional<String>> oos = op.map(Person::getName);
        String name1 = oos.get().orElseGet(()->"noName");
        Optional<String> os = op.flatMap(Person::getName);
        String name = os.orElseGet(()->"noName");
    }

    public static void mapTest(){
        Optional<Integer> oi = Optional.of("abcdefg").map(e -> e.length());
        System.out.println(oi.get());
    }

    public static void filterTest(){
        Optional<String> os = Optional.of("123456").filter(e -> e.length()>7);
        System.out.println(os.isPresent());
    }
}
class Person{
    Optional<String> name;
    public Person(String name){
        this.name = Optional.of(name);
    }

    public Optional<String> getName(){
        return name;
    }
}