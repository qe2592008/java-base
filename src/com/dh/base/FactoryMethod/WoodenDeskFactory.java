package com.dh.base.FactoryMethod;

/**
 * 木质桌子工厂
 */
public class WoodenDeskFactory implements DeskFactory{
    @Override
    public Desk createDesk(){
        return new WoodenDesk();
    }
}
