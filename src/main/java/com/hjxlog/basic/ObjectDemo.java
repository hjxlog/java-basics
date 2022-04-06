package com.hjxlog.basic;

/**
 * @Author: Huang JX
 * @Date: 2022/04/06
 * @Description:
 * 总结：
 * 1. static 静态的成员变量，属于类
 * 2. 没有static修饰的，不属于类，需要实例化
 */
public class ObjectDemo {

    /**
     * static属于类
     */
    private final static String value = "final"; // 用final修饰，必须要先初始化
    private static String name; // 默认值null
    private static int num; // 默认值 0

    private String password;

    public static void main(String[] args) {
        System.out.println(ObjectDemo.name);
        System.out.println(ObjectDemo.num);


        /**
         * new ObjectDemo(); 这个在堆内存中
         * objectDemo 这个是引用，等你运行起来的时候，存在于虚拟机栈中
         */
        ObjectDemo objectDemo = new ObjectDemo();
        // 属于对象
        System.out.println(objectDemo.password);
        // ObjectDemo.password 会报错，不是静态类，没有加载实例化之前不知道是什么值

    }

}
