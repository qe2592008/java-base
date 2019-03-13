package com.dh.base.abstractFactory;

/**
 * 塑料桌
 */
public class PlasticDesk implements Desk {
    private String type = "塑料桌";
    @Override
    public String getType() {
        return type;
    }
}
