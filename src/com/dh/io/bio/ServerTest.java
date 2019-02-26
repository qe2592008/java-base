package com.dh.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(12332);
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                OutputStream os = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\test.txt"));
                ) {
            byte[] bs = new byte[1024];
            is.read(bs);
            os.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
