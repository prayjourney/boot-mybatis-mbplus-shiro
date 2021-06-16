package com.zgy.learn.nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * @author: zgy
 * @date:2021/6/16
 */
public class UseBuffer {
    public static void main(String[] args) throws UnsupportedEncodingException {
        allocateBuffer();
        readBufferData();
        reReadAndClear();
    }

    /**
     * 分配缓冲区
     *
     * @throws UnsupportedEncodingException
     */
    public static void allocateBuffer() throws UnsupportedEncodingException {
        // 1. 分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String str = "Hello world!!!";
        // 2. 使用put把数据放入到缓冲区
        buf.put(str.getBytes("UTF-8"));
        System.out.println("capacity: " + buf.capacity());
        System.out.println("limit: " + buf.limit());
        System.out.println("position: " + buf.position());
        System.out.println("=========================\n");
    }

    /**
     * 读取缓冲区之中的数据
     *
     * @throws UnsupportedEncodingException
     */
    public static void readBufferData() throws UnsupportedEncodingException {
        // 1. 分配指定大小的缓冲区, 非直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("limit: " + buffer.limit());
        System.out.println("position: " + buffer.position());
        String str = "十步杀一人，千里不留行。";
        // 2. 使用put把数据放入到缓冲区
        buffer.put(str.getBytes("UTF-8"));
        // 3. 切换到读数据模式
        buffer.flip();
        // 4.使用get获取缓冲区之中的数据
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));

        // capacity是总容量大小, limit是实际占用的大小, position是实际
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("limit: " + buffer.limit());
        System.out.println("position: " + buffer.position());
        System.out.println("=========================\n");
    }

    /**
     * 重复读取+清空缓冲区
     *
     * @throws UnsupportedEncodingException
     */
    public static void reReadAndClear() throws UnsupportedEncodingException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("limit: " + buffer.limit());
        System.out.println("position: " + buffer.position());
        buffer.put("十步杀一人，千里不留行。".getBytes("UTF-8"));
        buffer.flip();
        byte[] bts = new byte[buffer.limit()];
        // ByteBuffer byteBuffer = buffer.get(bts);
        // System.out.println(new String(byteBuffer.toString())); // java.nio.HeapByteBuffer[pos=36 lim=36 cap=1024]

        buffer.get(bts);
        System.out.println(new String(bts));
        System.out.println("==>capacity: " + buffer.capacity());
        System.out.println("==>limit: " + buffer.limit());
        System.out.println("==>position: " + buffer.position());

        // 5. 重复读取
        buffer.rewind();
        System.out.println("<==capacity: " + buffer.capacity());
        System.out.println("<==limit: " + buffer.limit());
        System.out.println("<==position: " + buffer.position());
        byte[] bts02 = new byte[buffer.limit()];
        buffer.get(bts02);
        System.out.println(new String(bts02));

        // 6. 清空缓冲区
        buffer.clear();
        System.out.println("***capacity: " + buffer.capacity());
        System.out.println("***limit: " + buffer.limit());
        System.out.println("***position: " + buffer.position());
        System.out.println("=========================\n");

    }

}
