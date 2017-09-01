package com.hpu.buffer;

import java.nio.IntBuffer;

/**
 * @Author: li_zhilei
 * @Date: create in 12:30 17/8/22.
 * @description:
 * buffer的三个特性,类似于一个数组
 * 1. capacity
 * 1. position
 * 2. limit
 */
public class IntBufferAPI {

    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(8);

        for (int i = 0;i < intBuffer.capacity(); i++){
            int j = i * 2;
            intBuffer.put(j);
        }

        //反转buffer，limit = position ,position = 0
        intBuffer.flip();

        while (intBuffer.hasRemaining()){
            int j = intBuffer.get();
            System.out.println("j = " + j);
        }
    }

}
