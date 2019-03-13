package com.dh.base.simpleFactory;

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
