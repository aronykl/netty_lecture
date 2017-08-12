package com.shengsiyuan.netty.thirdexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 多人聊天程序 客户端
 * @Author: zhouwen
 * @Date: 2017/8/12 13:39
 */
public class MyChatClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(bossGroup).channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for ( ; ; ) {
                channel.writeAndFlush(br.readLine() + "\r\n");
            }

        } finally {
            bossGroup.shutdownGracefully();
        }
    }
}
