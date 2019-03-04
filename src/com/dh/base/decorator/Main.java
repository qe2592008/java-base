package com.dh.base.decorator;

public class Main {
    public static void main(String[] args) {
        House donghaoHouse = new DonghaoHouse();
        House decorator = new Decorator(donghaoHouse);
        decorator.output();
    }
}
