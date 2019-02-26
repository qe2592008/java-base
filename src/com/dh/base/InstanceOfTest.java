package com.dh.base;

public class InstanceOfTest {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        Sun sun = new Sun();
        System.out.println(sun instanceof Sun);
        System.out.println(son instanceof Sun);

    }
}

class Father {}

class Son extends Father {}

final class Sun extends Son{}