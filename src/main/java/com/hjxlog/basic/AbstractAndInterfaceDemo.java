package com.hjxlog.basic;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description
 */
public class AbstractAndInterfaceDemo implements MyInterface{

    public static void main(String[] args) {
        MyAbstractClass abstractClass = new MyAbstractClass() {
            @Override
            void eat() {

            }
        };
        abstractClass.getKey();

        AbstractAndInterfaceDemo abstractAndInterfaceDemo = new AbstractAndInterfaceDemo();
        abstractAndInterfaceDemo.getDefault();
    }

    @Override
    public void sound() {

    }

    @Override
    public void getValue() {

    }
}

interface MyInterface{
    // 默认是public static final
    public static final String str = "hello world";

    void sound();

    abstract void getValue();

    // 接口中可以使用default方法
    default void getDefault(){
//        str = "string"; // 默认是public static final
        System.out.println("MyInterface default方法...");
        System.out.println(str);
    }
}

/**
 * 如果有抽象方法，必须声明类为抽象类
 */
abstract class MyAbstractClass{
    // 抽象方法不可以有方法体
    abstract void eat();

    void getKey(){
        System.out.println("getKey方法...");
    }

//    default void getDefault(){
//
//    }
}