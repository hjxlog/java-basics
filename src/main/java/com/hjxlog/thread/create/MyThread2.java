package com.hjxlog.thread.create;

/**
 * @author Huang JX
 * @date 2022/4/3
 * 创建线程的方式二：实现Runnable接口，重写run()，Thread thread = new Thread(new Runnable{...})
 */
public class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + "====>" +i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread2());
        Thread thread2 = new Thread(new MyThread2());
        Thread thread3 = new Thread(new MyThread2());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
