package com.hjxlog.thread.demo;

/**
 * @Author: Huang JX
 * @Date: 2022/04/14
 * @Description:
 */
public class Demo01 {

    static Integer num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (num < 10000) {
                        System.out.println("thead name:" + Thread.currentThread().getName() + ":" + num++);
                    }
                }
            }).start();
        }
    }

}
