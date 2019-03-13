package com.dh.base.abstractFactory;

/**
 * 测试类
 */
public class Clienter {
    public static void main(String[] args) {
        FurnitureFactory factory = new PlasticFurnitureFactory();
        Desk desk = factory.createDesk();
        Chair chair = factory.createChair();
        System.out.println(desk.getType());
        System.out.println(chair.getType());
    }
}
