package com.dh.base.command;

/**
 * 发令方
 */
public class Invoker {
    private Command command;
    public Invoker(Command command){
        this.command = command;
    }
    public void order(){
        command.execute();
    }
}
