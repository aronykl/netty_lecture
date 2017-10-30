package com.shengsiyuan.nio;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        while (true) {
            buffer.clear();//如果注释掉会发生什么情况？

            int read = inputChannel.read(buffer);

            System.out.println("read : " + read);
            if (-1 == read) {
                break;
            }
            buffer.flip();

            outputChannel.write(buffer);

            System.out.println("position: " + buffer.position());
            System.out.println("limit: " + buffer.limit());
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
