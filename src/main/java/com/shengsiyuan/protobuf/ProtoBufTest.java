package com.shengsiyuan.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/8/16 23:13
 */
public class ProtoBufTest {

    public static void main(String[] args) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三").setAge(25).setAddress("北京").build();

        byte[] student2ByteArray = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(student2ByteArray);

        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getAddress());
    }
}
