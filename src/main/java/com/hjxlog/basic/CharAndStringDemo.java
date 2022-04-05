package com.hjxlog.basic;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description 字符串和String的区别
 */
public class CharAndStringDemo {

    public static void main(String[] args) {
        // 字符是ASCII值，整型值，占两个字节
        char a = 'A';
        // 可以参与表达式运算
        System.out.println(a - 10);

        // 字符串是常量代表的是一个地址，内存中存放的位置
        String str = "abc";
        System.out.println(str);
    }

}
