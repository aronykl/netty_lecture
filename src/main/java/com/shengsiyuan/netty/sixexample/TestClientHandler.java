package com.shengsiyuan.netty.sixexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/8/27 16:50
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int randomInt = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;

        if (0 == randomInt) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder().setName("张三").setAge(20).setAddress("北京").build())
                    .build();
        } else if (1 == randomInt) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder().setName("一只狗").setAge(20).build())
                    .build();
        } else {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.CatType)
                    .setCat(MyDataInfo.Cat.newBuilder().setName("一只猫").setCity("上海").build())
                    .build();
        }

        ctx.writeAndFlush(myMessage);

//        MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
//                .setName("张三").setAge(20).setAddress("北京").build();
//
//        ctx.writeAndFlush(person);
    }
}
