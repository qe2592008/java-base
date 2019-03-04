package com.dh.base.command;

/**
 * 命令接收方
 */
public class Receiver {
    public Receiver(String name){
        this.name = name;
    }
    private String name;
    public void toDo(String message){
        System.out.println(name+"执行命令："+message);
    }
}
