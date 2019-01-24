package com.dh.base;

public class CloneTest {
    public static void main(String[] args) {
        B b = new B();
        // 执行浅拷贝
        System.out.println("执行浅拷贝：");
        B cb1 = (B)b.clone();
        System.out.println(cb1.equals(b));// false-表示clone的对象与原对象不同
        System.out.println((cb1.getA()).equals(b.getA()));// true-表示浅拷贝引用对象不变
        // 执行深拷贝
        System.out.println("----------------");
        System.out.println("执行深拷贝：");
        B cb2 = (B)b.clone();
        A ca = (A)b.getA().clone();
        cb2.setA(ca);
        System.out.println(cb2.equals(b));// false-表示clone的对象与原对象不同
        System.out.println((cb2.getA()).equals(b.getA()));// true-表示浅拷贝引用对象不变
    }
}

class A implements Cloneable{
    int i = 20;
    A(){}
    A(int i){
        this.i = i;
    }
    public Object clone (){
        A a = null;
        try {
            a = (A)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return a;
    }
}
class B implements Cloneable{

    private int i = 10;

    private A a = new A(11);

    public Object clone () {
        B b = null;
        try {
            b = (B)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}