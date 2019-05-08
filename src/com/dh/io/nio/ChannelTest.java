package com.dh.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Channel的四大实现类为：
 *    FileChannel
 *    DatagramChannel
 *    SocketChannel
 *    ServerSocketChannel
 */
public class ChannelTest {
	public static void main(String[] args) throws IOException {
	  // 1-FileChannel的使用
		// 1-1 打开通道
		InputStream inputStream = new FileInputStream(new File(""));
		FileChannel channel = ((FileInputStream) inputStream).getChannel();// 获取输入通道
		OutputStream outputStream = new FileOutputStream(new File(""));
		FileChannel channel1 = ((FileOutputStream) outputStream).getChannel();// 获取输出通道
		RandomAccessFile access = new RandomAccessFile("","rw");
		FileChannel channel2 = access.getChannel();// 获取文件流通道，双向通道
		// 1-2 读取数据/写入数据
		ByteBuffer buffer = ByteBuffer.allocate(100);
		channel.read(buffer);// 读取数据到缓存
		buffer.flip();//切换模式
		channel1.write(buffer);// 写入数据到通道
		// 1-3 关闭通道
		channel.close();
		channel1.close();
		channel2.close();
		// 2-DatagramChannel的使用-UDP数据报
		// 2-1 打开通道
		DatagramChannel channel3 = DatagramChannel.open();
		channel3.bind(new InetSocketAddress(1234));
		// 2-2 接收数据
		ByteBuffer buffer1 = ByteBuffer.allocate(100);
		channel3.receive(buffer1);// 接收数据，将数据写入buffer
		// 2-3 发送数据
		ByteBuffer buffer2 = ByteBuffer.allocate(100);
		buffer2.clear();
		buffer2.put((byte)12);
		buffer2.flip();
		channel3.send(buffer2, new InetSocketAddress("localhost",1234));
		// 3-SocketChannel和ServerSocketChannel的使用-TCP
		// 3-1 客户端-打开通道
		SocketChannel channel4 = SocketChannel.open();
		channel4.connect(new InetSocketAddress(1235));// 连接到服务器
		// 3-2 客户端-发送数据
		ByteBuffer buffer3 = ByteBuffer.allocate(1000);
		buffer3.put((byte)123);
		buffer3.flip();
		channel4.write(buffer3);// 将缓存数据写入通道
		// 3-3 客户端-读取数据
		ByteBuffer buffer4 = ByteBuffer.allocate(1000);
		channel4.read(buffer4);// 从通道读取数据到缓存
		// 3-4 客户端-关闭通道
		channel4.close();
		// 3-5 服务端-打开通道
		ServerSocketChannel channel5 = ServerSocketChannel.open();
		channel5.bind(new InetSocketAddress("localhost", 1235));
		SocketChannel channel6 = channel5.accept();// 打开通道
		// 3-6 服务端-接收数据
		ByteBuffer buffer5 = ByteBuffer.allocate(1000);
		channel6.read(buffer5);// 读取通道数据到缓存
		// 3-7 服务端-反馈数据
		ByteBuffer buffer6 = ByteBuffer.allocate(1000);
		buffer6.put((byte)111);
		buffer6.flip();// 切换缓存模式
		channel6.write(buffer6);// 将缓存数据写入通道
		// 3-8 服务端-关闭通道
		channel6.close();
		channel5.close();
	}
}
