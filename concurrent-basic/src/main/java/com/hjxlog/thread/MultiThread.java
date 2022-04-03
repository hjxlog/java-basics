package com.hjxlog.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author: Huang JX
 * @Date: 2022/04/01
 * @Description:
 */
public class MultiThread {
    /**
     * 程序启动的时候，就是启动了一个JVM进程，
     * main 函数所在的线程就是这个进程中的一个线程，也称主线程。
     */
    public static void main(String[] args) {
        /**
         * 线程是一个比进程更小的执行单位。一个进程在其执行的过程中可以产生多个线程。
         */
        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}

