package com.hjxlog.thread.create;

/**
 * @author Huang JX
 * @date 2022/4/3
 * 创建线程的方式一：继承Thread，重写run()，执行start()
 */
public class MyThread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() +"===>"+i);
        }
    }

    public static void main(String[] args) {
        MyThread1 tread1 = new MyThread1();
        MyThread1 tread2 = new MyThread1();
        MyThread1 tread3 = new MyThread1();

        // 启动线程
        tread1.start();
        tread2.start();
        tread3.start();

        // 普通方法
        tread1.run();
        tread2.run();
        tread3.run();
    }

}
