package com.hjxlog.basic;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description 可变长度
 */
public class VariableLengthArgument {

    public static void main(String[] args) {
        fun("hi");
        fun("aa","hello","world","!");
    }

    public static void fun(String var1,String... strings){
        System.out.println(var1);
        // 可变长度就类似数组，可以用数组的形式遍历
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

}
