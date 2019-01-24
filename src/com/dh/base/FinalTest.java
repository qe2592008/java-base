package com.dh.base;

public class FinalTest {
//    final int i = 1;
//    int j = 2;
//    static int m = 3;
//    static final int n = 4;
    final int i;
    int j;
    static int m;
    static final int n;
    {
        i = 1;
    }
    static {
        n = 3;
    }
    public void outMethod(){
        final int s = 1;
        class innerClass{
            public void innerMethod(){
                System.out.println(s);
            }
        }
    }
}
class FinallyTest{
    public void test(){
        try{
            //someExecute
        }catch(Exception e){
            //someExecute
        }finally{
            //someExecute
        }
    }
}

class FinalizedTest{
    @Override
    public void finalize(){
        // do something
    }
}