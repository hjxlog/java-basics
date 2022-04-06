package com.hjxlog.basic;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description 可变长度
 * 总结：
 * 1. 可变参数要放在最后一个参数，且不能有多个，不然肯定有人不是最后一个...
 * 2. 如果有可变参数和固定参数两个重载方法，优先走的固定参数方法
 */
public class VariableLengthArgument {

    public static void main(String[] args) {
//        fun("hi");
//        fun("aa","hello","world","!");
        fun("aa","bb"); // 先进入的fun(String var1,String var2)，固定参数
    }

    public static void fun(String var1,String var2){
        System.out.println(var1);
        System.out.println(var2);
    }

    public static void fun(String var1,String... strings){
        System.out.println("=====可变参数方法=====");
        System.out.println(var1);
        // 可变长度就类似数组，可以用数组的形式遍历
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

}
