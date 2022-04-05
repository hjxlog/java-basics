package com.hjxlog.collection;


import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description CAS技术
 */
public class CASDemo {

    public static int i = 0;

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int oldValue = i;
                System.out.println("当前内存值：" + oldValue);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                i = i + 1;
                boolean result = compareAndSwap(oldValue, i, i + 1);
                System.out.println("设置是否成功：" + result);
                System.out.println("新值：" + i);
            }
        });
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 干扰
        i = 5;
    }

    /**
     * CAS技术 防止变量在使用的过程中被其他线程修改，只有内存值=预期原值的时候，才交换
     * 否则，则是有其他线程更改了变量值
     *
     * @param oldValue      内存值
     * @param exceptedValue 预期原值
     * @param newValue      新值
     * @return
     */
    public static boolean compareAndSwap(int oldValue, int exceptedValue, int newValue) {
        // 当预期值等于内存值，说明没有人干扰，可以赋值
        if (exceptedValue == oldValue) {
            i = newValue;
            return true;
        }
        // 有人干扰
        return false;
    }
}
