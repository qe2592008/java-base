package com.dh.base.FactoryMethod;

/**
 * 测试类
 */
public class Clienter {
    public static void main(String[] args) {
        DeskFactory factory = new WoodenDeskFactory();
        Desk desk = factory.createDesk();
        System.out.println(desk.getType());
    }
}
