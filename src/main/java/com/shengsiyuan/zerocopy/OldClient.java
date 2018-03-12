package com.shengsiyuan.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2018/1/26 18:28
 */
public class OldClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8899);

        String fileName = "/Users/zhouwen/Desktop/spark-2.2.1-bin-hadoop2.7.tgz";
        FileInputStream fileInputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[4096];
        long readCount;
        long totalCount = 0;

        long startTime = System.currentTimeMillis();

        while (-1 != (readCount = fileInputStream.read(bytes, 0, bytes.length))) {
            totalCount += readCount;
            dataOutputStream.write(bytes);
        }

        System.out.printf("发送总字节数： " + totalCount + ", 耗时：" + (System.currentTimeMillis() - startTime));
        dataOutputStream.close();
        socket.close();
        fileInputStream.close();

    }
}
