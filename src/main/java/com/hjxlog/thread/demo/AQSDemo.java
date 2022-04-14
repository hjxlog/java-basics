package com.hjxlog.thread.demo;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: Huang JX
 * @Date: 2022/04/14
 * @Description:
 */
public class AQSDemo {

    public static void main(String[] args) {
        /**
         *     The synchronization state.
         *
         * private volatile int state; // 判断贡献资源是否被占用的标志位 为什么是Int不是boolean
         * 这就涉及到 线程获取锁的两种模式：独占和共享
         */
        AbstractQueuedSynchronizer abstractQueuedSynchronizer = null;
    }

}
