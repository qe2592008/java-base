package com.dh.base.abstractFactory;

/**
 * 家具工厂
 */
public interface FurnitureFactory {
    Desk createDesk();
    Chair createChair();
}
