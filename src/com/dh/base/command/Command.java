package com.dh.base.command;

/**
 * 命令抽象层
 */
public abstract class Command {
    private Receiver receiver;
    protected String message;
    public Command(Receiver receiver){
        this.receiver = receiver;
    }
    public void execute(){
        receiver.toDo(message);
    }
}
