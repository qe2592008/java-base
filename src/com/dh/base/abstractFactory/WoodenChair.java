package com.dh.base.abstractFactory;

/**
 * 木质椅
 */
public class WoodenChair implements Chair {
    private String type = "木质椅";
    @Override
    public String getType() {
        return type;
    }
}
