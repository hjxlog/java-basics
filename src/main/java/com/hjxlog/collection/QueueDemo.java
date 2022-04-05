package com.hjxlog.collection;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.PriorityQueue;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description
 */
public class QueueDemo {
    public static void main(String[] args) {

        // transient Object[] queue; 数组实现的二叉堆
        PriorityQueue priorityQueue = new PriorityQueue();

        // Object[] 数组 + 双指针
        ArrayQueue arrayQueue = new ArrayQueue(10);
    }
}
