package com.hjxlog.thread.demo;

/**
 * @Author: Huang JX
 * @Date: 2022/04/14
 * @Description:
 */
public class Demo01_1 {

    static Integer num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (num < 10000) {
                        synchronized (Demo01_1.class){
                            System.out.println("thead name:" + Thread.currentThread().getName() + ":" + num++);
                        }
                    }
                }
            }).start();
        }
    }

}
