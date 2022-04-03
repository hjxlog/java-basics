package com.hjxlog.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class Summary {

    public static void main(String[] args) {
        /**
         * extends AbstractSet<E>
         * implements Set<E>
         * 元素唯一，不是线程安全的
         * 底层数据结构是哈希表（基于 HashMap 实现）
         *    private transient HashMap<E,Object> map;
         */
        HashSet hashSet = new HashSet();

        /**
         * extends HashSet<E> HashSet的子类
         * 底层数据结构是链表和哈希表
         * 元素的插入和取出顺序满足 FIFO
         */
        LinkedHashSet linkedHashSet = new LinkedHashSet();

        /**
         * TreeSet 底层数据结构是红黑树，
         * 元素是有序的，排序的方式有自然排序和定制排序。
         */
        TreeSet treeSet = new TreeSet();

        /**
         * HashSet 用于不需要保证元素插入和取出顺序的场景，
         * LinkedHashSet 用于保证元素的插入和取出顺序满足 FIFO 的场景，
         * TreeSet 用于支持对元素自定义排序规则的场景。
         */


        // ===========================



    }

}

