package com.dh.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {
    public static void main(String[] args) {
        Object s = "12";
        Integer w = (Integer)s;




        // try-with-resources
        try(InputStream is = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\text.txt"))){
            byte[] bs = new byte[100];
            is.read(bs);
            System.out.println(bs.toString());
            int i = 1/0;
        }catch(IOException e){
            e.printStackTrace();
//            Throwable[] ts = e.getSuppressed();
            System.out.println("catch");
        }finally{
            System.out.println("finally");
        }
    }
}
