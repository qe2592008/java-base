package com.dh.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class BufferTest {
	public static void main(String[] args) {
		// 1-分配内存，创建Buffer
		ByteBuffer buf1 = ByteBuffer.allocate(100);
		ShortBuffer buf2 = ShortBuffer.allocate(100);
		IntBuffer buf3 = IntBuffer.allocate(100);
		CharBuffer buf4 = CharBuffer.allocate(100);
		LongBuffer buf5 = LongBuffer.allocate(100);
		FloatBuffer buf6 = FloatBuffer.allocate(100);
		DoubleBuffer buf7 = DoubleBuffer.allocate(100);
	  // 2-写入数据
		buf1.put((byte)120);
		buf2.put((short)120);
		buf3.put(120);
		buf4.put('1');
		buf5.put(120L);
		buf6.put(120f);
		buf7.put(120d);
		// 3-切换模式
		buf1.flip();
		// 4-读取数据
		byte b = buf1.get();
		byte[] bs = buf1.array();
		// 5-清除数据
		buf1.compact();
		buf1.clear();
	}
}
