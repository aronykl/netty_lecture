package com.shengsiyuan.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2018/1/26 19:48
 */
public class NewIOClient {

    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));

        socketChannel.configureBlocking(true);
        String fileName = "/Users/zhouwen/Desktop/spark-2.2.1-bin-hadoop2.7.tgz";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();

        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送总总字节数：" + transferCount + ", 耗时：" + (System.currentTimeMillis() - startTime));

    }
}
