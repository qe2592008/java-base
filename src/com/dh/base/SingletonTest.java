package com.dh.base;

public class SingletonTest {
}

class SingletonOne {
    public static SingletonOne singleton;
    private SingletonOne() {}
    public static  SingletonOne getSingleton() {
        if (singleton == null)
            return new SingletonOne();
        return singleton;
    }
}

class SingletonTwo {
    public static SingletonTwo singleton;
    private SingletonTwo() {}
    public static synchronized SingletonTwo getSingleton() {
        if (singleton == null)
            return new SingletonTwo();
        return singleton;
    }
}

class SingletonThree {
    public static SingletonThree singleton = new SingletonThree();
    private SingletonThree () { }
    public static SingletonThree getSingleton() {
        return singleton;
    }
}

class SingletonFour {
    public static SingletonFour singleton;
    static {
        singleton = new SingletonFour();
    }
    private SingletonFour () { }
    public static SingletonFour getSingleton() {
        return singleton;
    }
}

class SingletonFive {
    private static class SingletonHolder {
        private static SingletonFive singleton = new SingletonFive();
    }
    private SingletonFive () {}
    public static final SingletonFive getSingleton(){
        return SingletonHolder.singleton;
    }
}

enum SingletonSix {
    SINGLETON;
    public void whateverMethod() {

    }
}

class SingletonSeven {
    private static volatile SingletonSeven singleton;
    private SingletonSeven() {}
    public static SingletonSeven getSingleton(){
        if (singleton == null) {
            synchronized (SingletonSeven.class) {
                if (singleton == null)
                    return new SingletonSeven();

            }
        }
        return singleton;
    }
}