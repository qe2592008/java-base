package com.dh.base.FactoryMethod;

import com.dh.base.FactoryMethod.Desk;

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
