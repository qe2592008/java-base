package com.dh.io;

import java.io.*;

public class IOTest {
    public static void main(String[] args) {

    }

    public static void ioTest1() throws FileNotFoundException {
        // 输入流
        InputStream is = new BufferedInputStream(new FileInputStream(""));
        InputStream iss = new DataInputStream(is);
    }
}
