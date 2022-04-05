package com.hjxlog.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description
 */
public class MapDemo {

    public static void main(String[] args) {

        /**
         * 1.8之前 数组+链表
         *
         * 1.8 数组+链表+红黑树
         *
         * HashMap 默认的初始化大小为 16。之后每次扩充，容量变为原来的 2 倍
         */

        HashMap hashMap = new HashMap();


        /**
         * 继承自 HashMap,底层跟hashMap差不多一致
         */
        LinkedHashMap linkedHashMap = new LinkedHashMap();


        /**
         * 数组+链表
         */
        Hashtable hashtable = new Hashtable();


        /**
         * 红黑树
         */
        TreeMap treeMap = new TreeMap();


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    }

}
