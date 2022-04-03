package com.hjxlog.thread.sync;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class Demo01 {
    public static void main(String[] args) {

    }

    /**
     * 修饰实例方法: 作用于当前对象实例加锁，进入同步代码前要获得 当前对象实例的锁
     */
    public synchronized void fun(){
        System.out.println("hello world");
    }

    /**
     * 修饰静态方法: 也就是给当前类加锁，会作用于类的所有对象实例 ，进入同步代码前要获得 当前 class 的锁。
     */
    synchronized static void method() {
        //业务代码
    }

    /**
     * 修饰代码块 ：指定加锁对象，对给定对象/类加锁。
     */
    public void fun2(){
        synchronized(this) {
            //业务代码
        }
    }

    public void fun3(){
        synchronized(Demo01.class) {
            //业务代码
        }
    }
}
