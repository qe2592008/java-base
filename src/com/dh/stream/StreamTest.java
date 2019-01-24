package com.dh.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void createStream() {
        // 通过数组生成流
        int[] ints = {1,2,3,4,5,6};
        IntStream s1 = Arrays.stream(ints);
        Stream s2 = Stream.of("111","222","333");
        String[] ss = {"123","321","456","654"};
        Stream<String> s3 = Arrays.stream(ss);
        // 通过构建器生成流
        Stream<Object> s4 = Stream.builder().add("123").add("321").add("444").add("@21").build();
        // 通过集合生成流
        List<String> lists = Arrays.asList("123","321","1212","32321");
        Stream<String> s5 = lists.stream();
        Stream<String> s6 = lists.parallelStream();
        // 创建空流
        Stream<String> s7  = Stream.empty();
        // 创建无限流
        Stream.generate(()->"number"+new Random().nextInt()).limit(100).forEach(System.out::println);
        Stream.iterate(0,n -> n+2).limit(10).forEach(System.out::println);
    }

    public static void filterTest(List<String> list){
        list.stream()
                .filter(e -> e.length() > 4 && e.length()<7)// 过滤掉长度小于等于4,大于等于7的元素
                .peek(System.out::println)// 查阅中间流结果
                .collect(Collectors.toList());
    }

    public static void mapTest(List<String> list){
        list.stream()
                .map(e -> "@" + e)// 为每个元素执行操作：添加前缀
                .peek(System.out::println)// 查阅中间流结果
                .collect(Collectors.toList());
    }

    public static void mapToIntTest(List<String> list){
        list.stream()
                .mapToInt(e -> e.length())// 以元素的长度为新流
                .peek(System.out::println)// 查询中间结果
                .toArray();
    }
    public static void flatMap(List<String> list){
        list.stream()
                .filter(e -> e.length()>5 && e.length()<7)
                .peek(System.out::println)
                .map(e -> e.split(""))// 将每个字符串元素分解为字符数组
                .flatMap(Arrays::stream)//将每个字符数组并转化为流
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public static void distinctTest(){
        int[] int1 = {1,2,3,4};
        int[] int2 = {5,3,7,1};
        List<int[]> ints = Arrays.asList(int1,int2);
        ints.stream()
                .flatMapToInt(Arrays::stream)
                .distinct()
                .peek(System.out::println)
                .toArray();
    }

    public static void sortedTest(List<String> list){
        System.out.println("----自然顺序:");
        list.stream().sorted().peek(System.out::println).collect(Collectors.toList());
        System.out.println("----指定排序:");
        list.stream().sorted((a,b) -> a.length()-b.length()).peek(System.out::println).collect(Collectors.toList());
    }

    public static void limitTest(List<String> list){
        list.stream().limit(2).peek(System.out::println).collect(Collectors.toList());
    }

    public static void skipTest(List<String> list){
        list.stream().skip(2).peek(System.out::println).collect(Collectors.toList());
    }

    public static void forEachTest(List<String> list){
        list.stream().parallel().forEach(System.out::println);
    }

    public static void forEachOrderedTest(List<String> list){
        list.stream().parallel().forEachOrdered(System.out::println);
    }

    public static void toArrayTest(List<String> list){
        Object[] objs = list.stream().filter(e -> e.length()>6).toArray();
        String[] ss = list.stream().filter(e -> e.length()>6).toArray(String[]::new);
    }

    public static void reduceTest(){
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Optional<Integer> optional = ints.stream().reduce(Integer::sum);
        System.out.println(optional.get());
        System.out.println("-------------");
        Integer max = ints.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println(max);
        System.out.println("-------------");
        Integer min = ints.parallelStream().reduce(Integer.MAX_VALUE, Integer::min, Integer::min);
        System.out.println(min);
    }

    public static void collectTest1(List<String> list){
        ArrayList<String> arrayList = list.stream().skip(4).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        arrayList.forEach(System.out::println);
    }

    public static void collectTest2(List<String> list){
        Set<String> set = list.stream().skip(4).collect(Collectors.toSet());
        set.forEach(System.out::println);
    }

    public static void maxMinTest(List<String> list){
        System.out.println("长度最大：" + list.stream().max((a,b)-> a.length()-b.length()));
        System.out.println("长度最小：" + list.stream().min((a,b)-> a.length()-b.length()));
    }

    public static void countTest(List<String> list){
        System.out.println("元素个数为：" + list.stream().count());
    }

    public static void anyMatchTest(List<String> list){
        System.out.println(list.stream().anyMatch(e -> e.length()>10));
        System.out.println(list.stream().anyMatch(e -> e.length()>8));
    }

    public static void allMatchTest(List<String> list){
        System.out.println(list.stream().allMatch(e -> e.length()>1));
        System.out.println(list.stream().allMatch(e -> e.length()>3));
    }

    public static void noneMatchTest(List<String> list){
        System.out.println(list.stream().noneMatch(e -> e.length()>10));
        System.out.println(list.stream().noneMatch(e -> e.length()>8));
    }

    public static void findFirstTest(List<String> list){
        System.out.println(list.stream().parallel().findFirst().get());
    }

    public static void findAnyTest(List<String> list){
        System.out.println(list.stream().parallel().findAny().get());
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123","456","789","1101","212121121","asdaa","3e3e3e","2321eew");
        createStream();
        filterTest(list);
        mapTest(list);
        mapToIntTest(list);
        flatMap(list);
        distinctTest();
        sortedTest(list);
        limitTest(list);
        skipTest(list);
        forEachTest(list);
        forEachOrderedTest(list);
        toArrayTest(list);
        reduceTest();
        collectTest1(list);
        collectTest2(list);
        maxMinTest(list);
        countTest(list);
        anyMatchTest(list);
        allMatchTest(list);
        noneMatchTest(list);
        findFirstTest(list);
        findAnyTest(list);
    }
}
