package com.dh.base;

public enum EnumTest {
    MAN{
        public String getName(){
            return "MAN";
        }
    },
    WOMAN{
        public String getName(){
            return "WOMAN";
        }
    };
    public abstract String getName();
    public static void main(String[] args) {
        System.out.println(EnumTest.values());
        System.out.println(EnumTest.valueOf("MAN"));
    }
}
