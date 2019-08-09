package com.dh.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. runAsync与supplyAsync的区别：前者用于执行无返回值的任务，后者用于执行带返回值的任务
 * 2. thenApply：可获得上个任务返回值，且当前任务有返回值
 *    thenAccept：能获得上个任务返回值，当前任务无返回值
 *    thenRun：不能获得上个任务返回值，当前任务也无返回值
 *    这三个方法用于顺序执行异步任务中，用于连接任务链，后两个无返回值，一般用在调用链的末端
 * 2. thenApply与thenApplyAsync的区别：后者指定使用ForkJoinPool.commonPool()
 * 中的线程执行任务，前者不指定目标任务的执行线程，如果目标任务执行速度快，那么thenApply由发起线程执行，否则由目标任务线程执行
 * 3. thenCompose：当第一个任务完成时才会执行第二个操作
 *    thenCombine：两个异步任务全部完成时才会执行某些操作
 *    allOf：组合任意数量任务，待所有任务全部完成才会触发回调函数
 *    anyOf：组合任意数量任务，只要有一个任务执行结束，则触发回调函数，其余任务自动停止
 * 4. exceptionally：发生异常的情况执行其中的内容，异常处理，类似catch
 *    handle：无论是否发生异常均执行其中的内容，类似finally
 */
public class AsyncOperate {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1- 创建异步任务
        // 1-1 创建无参异步任务-无返回值
        CompletableFuture noParamFuture = new CompletableFuture();
        CompletableFuture noParamFuture1 = CompletableFuture.runAsync(()->{});
        // 1-2 创建带参异步任务-带返回值
        CompletableFuture<String> hasParamFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "";
            }
        });
        // 2- 获取返回值-针对带参异步任务-会阻塞
        hasParamFuture.get();
        // 3- 应用
        // 3-1 按顺序执行异步任务
        // 3-1-1 thenApply使用-有参-有返回值
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->"Future1");
        CompletableFuture<String> future2 = future1.thenApply(s -> s + "Future2");
        System.out.println(future2.get());
        // 3-1-2 thenAccept使用-有参-无返回值
        CompletableFuture future3 = future1.thenAccept(System.out::println);
        // 3-1-3 thenRun使用-无参-无返回值
        CompletableFuture future4 = future1.thenRun(()->System.out.println("thenRun"));
        // 3-2 任务组合
        // 3-2-1 thenCompose使用
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(()->"Future5");
        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(()->"Future6");
        future5.thenCompose(s -> future6);
        // 3-2-2 thenCombine使用
        CompletableFuture<Integer> thenComposeOne = CompletableFuture.supplyAsync(() -> 192);
        CompletableFuture<Integer> thenComposeTwo = CompletableFuture.supplyAsync(() -> 196);
        CompletableFuture<Integer> thenComposeCount = thenComposeOne.thenCombine(thenComposeTwo, (s, y) -> s + y);
        System.out.println(thenComposeCount.get());
        // 3-2-3 allOf使用
        CompletableFuture<Integer> allOfOne = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Integer> allOfTwo = CompletableFuture.supplyAsync(() -> 2);
        CompletableFuture<Integer> allOfThree = CompletableFuture.supplyAsync(() -> 3);
        CompletableFuture<Integer> allOfFour = CompletableFuture.supplyAsync(() -> 4);
        CompletableFuture<Void> allOf = CompletableFuture.allOf(allOfOne, allOfTwo, allOfThree, allOfFour);
        allOf.thenApply(v -> {
            return Stream.of(allOfOne, allOfTwo, allOfThree, allOfFour).map(CompletableFuture::join).collect(Collectors.toList());
        }).thenAccept(System.out::println);
        // 3-2-4 anyOf使用
        CompletableFuture<Integer> allOfOne1 = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Integer> allOfTwo1 = CompletableFuture.supplyAsync(() -> 2);
        CompletableFuture<Object> future = CompletableFuture.anyOf(allOfOne1, allOfTwo1);
        future.get();
        // 4- 异常处理
        // 4-1 exceptionally使用
        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            return "success";
        }).exceptionally(e -> {
            System.out.println(e);
            return "exception";
        });
        // 4-2 handle使用
        CompletableFuture<String> handle = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            return "success";
        }).handle((response, e) -> {
           System.out.println(response);
           System.out.println(e);
           return response;
        });
    }
}
