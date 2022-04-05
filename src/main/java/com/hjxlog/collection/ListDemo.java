package com.hjxlog.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description
 */
public class ListDemo {
    public static void main(String[] args) {
        // 底层 transient Object[] elementData;  数组
        /**
         * 所以 ArrayList 每次扩容之后容量都会变为原来的 1.5 倍左右
         */
        ArrayList arrayList = new ArrayList();

        // 底层 protected Object[] elementData; 数组
        // 线程安全的，public synchronized void addElement(E obj)
        Vector vector = new Vector();


        /**
         * 双向链表
         *     private static class Node<E> {
         *         E item;
         *         Node<E> next;
         *         Node<E> prev;
         *     }
         */
        LinkedList linkedList = new LinkedList();

    }
}
