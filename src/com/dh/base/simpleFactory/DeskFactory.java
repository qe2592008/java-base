package com.dh.base.simpleFactory;

/**
 * 桌子工厂
 */
public class DeskFactory {
    public static Desk createDesk(Type type) {
        switch (type) {
            case WOODEN:
                return new WoodenDesk();
            case PLASTIC:
                return new PlasticDesk();
            default:
                return null;
        }
    }
}
