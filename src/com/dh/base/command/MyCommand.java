package com.dh.base.command;

/**
 * 具体的命令实现
 */
public class MyCommand extends Command {
    public MyCommand(Receiver receiver, String message) {
        super(receiver);
        this.message = message;
    }
}
