package com.dh.base.simpleFactory;

/**
 * 测试类
 */
public class Clineter {
    public static void main(String[] args) {
        Desk desk = DeskFactory.createDesk(Type.PLASTIC);
        System.out.println(desk.getType());
    }
}
