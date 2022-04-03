package com.hjxlog.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class Demo02 {

    public static void main(String[] args) {
        /**
         *     static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
         *     初始容量16
         *     newThr = oldThr << 1; // double threshold   扩容，变成原来的两倍，左移一位，*2
         *
         *
         *     创建时如果给定了容量初始值，HashMap 会将其扩充为 2 的幂次方大小
         *      为什么是 2 的幂次方？ n是代表容量长度
         *     数组下标的计算方法是(n - 1) & hash
         *
         *     取余(%)操作中如果除数是 2 的幂次则等价于与其除数减一的与(&)操作（
         *     也就是说 hash%length==hash&(length-1)的前提是 length 是 2 的 n 次方；）。”
         *     并且 采用二进制位操作 &，相对于%能够提高运算效率，这就解释了 HashMap 的长度为什么是 2 的幂次方。
         *
         *     loadFactor 太大导致查找元素效率低，太小导致数组的利用率低，存放的数据会很分散。
         *     loadFactor 的默认值为 0.75f 是官方给出的一个比较好的临界值。
         *
         *
         */
        HashMap hashMap = new HashMap<>();
        // HashMap 可以存储 null 的 key 和 value
        hashMap.put(null,null);
        System.out.println(hashMap);


        /**
         * 在java.util.concurrent包下
         *
         *  JDK1.7 的 ConcurrentHashMap 底层采用 分段的数组+链表 实现，
         *  JDK1.8 采用的数据结构跟 HashMap1.8 的结构一样，数组+链表/红黑二叉树。
         *
         *  到了 JDK1.8 的时候已经摒弃了 Segment 的概念，
         *  而是直接用 Node 数组+链表+红黑树的数据结构来实现，
         *  并发控制使用 synchronized 和 CAS 来操作。
         *
         *      final V putVal(K key, V value, boolean onlyIfAbsent) {
         *         if (key == null || value == null) throw new NullPointerException();
         *      key value 不得为null
         *
         *      多线程协同扩容
         *          final long sumCount() {
         *         CounterCell[] as = counterCells; CounterCell a;
         *         long sum = baseCount;
         *         if (as != null) {
         *             for (int i = 0; i < as.length; ++i) {
         *                 if ((a = as[i]) != null)
         *                     sum += a.value;
         *             }
         *         }
         *         return sum;
         *     }
         *     长度 baseCount + CounterCell[]
         *
         */
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        /**
         *     public Hashtable() {
         *         this(11, 0.75f);
         *     }
         *     初始大小为11
         *     之后每次扩充，容量变为原来的 2n+1
         *
         *     创建时如果给定了容量初始值，那么 Hashtable 会直接使用你给定的大小，
         */
        // Hashtable 不允许有 null 键和 null 值，否则会抛出 NullPointerException
        Hashtable hashtable = new Hashtable();
        hashtable.put(null,null);
        System.out.println(hashtable);


        /**
         *     public HashSet() {
         *         map = new HashMap<>();
         *     }
         *     底层HashSet 底层就是基于 HashMap 实现的，仅存储对象
         *
         *         public boolean add(E e) {
         *         return map.put(e, PRESENT)==null;
         *     }
         *     只存储Key,PRESENT是object
         *
         *         public V put(K key, V value) {
         *         return putVal(hash(key), key, value, false, true);
         *     }
         *     计算hashcode hash(key) ，如果不重复加进去，如果重复判断equals()，重新散列
         *
         */
        HashSet hashSet = new HashSet();
    }
}
