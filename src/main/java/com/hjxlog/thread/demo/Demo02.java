package com.hjxlog.thread.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Huang JX
 * @Date: 2022/04/13
 * @Description:
 */
public class Demo02 {

    private String s = "";

    private static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (num.get() < 1000) {
                    System.out.println(Thread.currentThread().getName() + "====>" + num.incrementAndGet());
                }
            }).start();
        }
    }

}
