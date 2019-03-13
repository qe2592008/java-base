package com.dh.base.FactoryMethod;

/**
 * 塑料桌子工厂
 */
public class PlasticDeskFactory implements DeskFactory {
    @Override
    public Desk createDesk() {
        return new PlasticDesk();
    }
}
