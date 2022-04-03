package com.hjxlog.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class Demo01 {
    // Comparator
    public static void main(String[] args) {
        /**
         * grow
         *
         *     private void grow(int minCapacity) {
         *         // overflow-conscious code
         *         int oldCapacity = elementData.length;
         *         // 扩容为原来的1.5倍
         *         int newCapacity = oldCapacity + (oldCapacity >> 1);
         *         // 增长1.5倍还是小于最小容量，那就用最小容量
         *         if (newCapacity - minCapacity < 0)
         *             newCapacity = minCapacity;
         *              //再检查新容量是否超出了ArrayList所定义的最大容量，
         *         //若超出了，则调用hugeCapacity()来比较minCapacity和 MAX_ARRAY_SIZE，
         *         //如果minCapacity大于MAX_ARRAY_SIZE，则新容量则为Interger.MAX_VALUE，否则，新容量大小则为 MAX_ARRAY_SIZE。
         *         //如果minCapacity大于最大容量，则新容量则为`Integer.MAX_VALUE`，否则，新容量大小则为 MAX_ARRAY_SIZE 即为 `Integer.MAX_VALUE - 8`。
         *         if (newCapacity - MAX_ARRAY_SIZE > 0)
         *             newCapacity = hugeCapacity(minCapacity);
         *         // minCapacity is usually close to size, so this is a win:
         *         // 复制
         *         elementData = Arrays.copyOf(elementData, newCapacity);
         *     }
         *
         *
         *
         *     以无参数构造方法创建 ArrayList 时，实际上初始化赋值的是一个空数组。
         *     当真正对数组进行添加元素操作时，才真正分配容量。
         *     即向数组中添加第一个元素时，数组容量扩为 10。
         */
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);
        // 定制排序的用法

        // public static <T> void sort(List<T> list, Comparator<? super T> c)
        Collections.sort(arrayList, new Comparator<Integer>() {
            // 使用自制的Comparator方法
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(arrayList);

    }
}
