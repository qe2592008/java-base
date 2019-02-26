package com.dh.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

public class ClientTest {
    public static void main(String[] args) {
        bioClient1();
        bioClient2();
    }

    public static void bioClient1(){
        try (Socket socket = new Socket("localhost",12332);
             OutputStream os = socket.getOutputStream();
             ) {
            String s = "test message";
            os.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void bioClient2(){
        try(Socket socket = new Socket(InetAddress.getLocalHost(),12333);
            OutputStream os = socket.getOutputStream();) {
            String s = "test message2";
            os.write(s.getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
