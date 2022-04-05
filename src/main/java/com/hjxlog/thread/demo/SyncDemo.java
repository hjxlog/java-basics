package com.hjxlog.thread.demo;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class SyncDemo{

    public static void main(String[] args) throws InterruptedException {
        long target = 1000;
        long[] x = new long[1];
        System.out.println("x[0]:"+x[0]);
        /**
         * 同一时刻，两个线程读取到一样的temp值，两个加1
         * 看上去加了两次，实际上结果只加了1
         */
        for (int i = 0; i < target; i++) {
            new Thread(()->{
                synchronized (SyncDemo.class){
                System.out.println(Thread.currentThread()+"====>"+x[0]);
                    x[0]++;
                }
            }).start();
        }

        Thread.sleep(3000);
        System.out.println("最终结果"+x[0]);

    }

}
