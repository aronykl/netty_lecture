package com.shengsiyuan.netty.test;

import io.netty.util.NettyRuntime;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2018/5/19 21:53
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(NettyRuntime.availableProcessors() * 2);
    }
}
