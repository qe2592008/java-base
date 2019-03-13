package com.dh.base.abstractFactory;

/**
 * 塑料椅
 */
public class PlasticChair implements Chair {
    private String type = "塑料椅";
    @Override
    public String getType() {
        return type;
    }
}
