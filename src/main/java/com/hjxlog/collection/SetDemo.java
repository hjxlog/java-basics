package com.hjxlog.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description
 */
public class SetDemo {
    public static void main(String[] args) {

        // 底层 map = new HashMap<>(); HashMap实现的
        // 无序，唯一
        HashSet hashSet = new HashSet();


        // 继承自 HashSet，用LinkedHashMap实现的

        LinkedHashSet linkedHashSet = new LinkedHashSet();


        // 有序，唯一的，基于红黑树实现
        TreeSet treeSet = new TreeSet();

    }
}
