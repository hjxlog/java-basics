package com.hjxlog.thread.demo;

import java.awt.*;

/**
 * @Author: Huang JX
 * @Date: 2022/04/14
 * @Description:
 */
public class CASDemo {

    public static void main(String[] args) {

    }

    /**
     * 例子有点问题，应该是引用类型的
     * 差不多那个意思，看懂就好
     * @param curValue 资源对象的当前值
     * @param oldValue 在此之前获取的资源对象的值
     * @param newValue 想要更新的值
     * @return
     */
    public static int cas(int curValue, int oldValue, int newValue) {
        if (curValue != oldValue) {
            return 0;
        }
        curValue = newValue;
        return 1;
    }

}
