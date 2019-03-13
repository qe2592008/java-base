package com.dh.base.abstractFactory;

/**
 * 木质家具工厂
 */
public class WoodenFurnitureFactory implements FurnitureFactory {
    @Override
    public Desk createDesk() {
        return new WoodenDesk();
    }

    @Override
    public Chair createChair() {
        return new WoodenChair();
    }
}

