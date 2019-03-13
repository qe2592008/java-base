package com.dh.base.abstractFactory;

/**
 * 木质桌子
 */
public class WoodenDesk implements Desk {
    private String type = "木质桌";
    @Override
    public String getType() {
        return type;
    }
}
