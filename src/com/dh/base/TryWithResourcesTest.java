package com.dh.base;

import java.io.*;

public class TryWithResourcesTest {
    public static void main(String[] args) {
        try (
                InputStream is = new FileInputStream(new File(""));
                OutputStream os = new FileOutputStream(new File(""))) {
            byte[] bs = new byte[100];
            is.read(bs);
            os.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // do other things
        }
    }
}
