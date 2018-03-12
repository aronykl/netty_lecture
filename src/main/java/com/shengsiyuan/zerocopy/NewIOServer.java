package com.shengsiyuan.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2018/1/26 18:47
 */
public class NewIOServer {

    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {

             SocketChannel socketChannel = serverSocketChannel.accept();
             socketChannel.configureBlocking(true);

             int readCount = 0;

             while (-1 != readCount) {
                 readCount = socketChannel.read(byteBuffer);

                 // Buffer 进行重置
                 byteBuffer.rewind();
             }
        }
    }
}
