package com.dh.base.abstractFactory;

/**
 * 塑料家具工厂
 */
public class PlasticFurnitureFactory implements FurnitureFactory {
    @Override
    public Desk createDesk() {
        return new PlasticDesk();
    }

    @Override
    public Chair createChair() {
        return new PlasticChair();
    }
}
