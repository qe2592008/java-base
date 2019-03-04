package com.dh.base.command;

/**
 * 测试类
 */
public class Clienter {
    public static void main(String[] args) {
        Receiver receiver = new Receiver("董存瑞");
        Command command = new MyCommand(receiver, "去把那个碉堡给炸了");
        Invoker invoker = new Invoker(command);
        invoker.order();
    }
}
