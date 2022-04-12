package com.hjxlog.thread.demo;

/**
 * @author Huang JX
 * @date 2022/4/12
 * @description
 */
public class NumberDemo implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //唤醒被阻塞的线程
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        //让当前线程进入阻塞状态，并且释放同步监视器
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new NumberDemo()).start();
        new Thread(new NumberDemo()).start();
    }
}

