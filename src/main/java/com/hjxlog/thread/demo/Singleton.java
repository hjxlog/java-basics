package com.hjxlog.thread.demo;

/**
 * @author Huang JX
 * @date 2022/4/3
 * 双重校验锁实现对象单例（线程安全）
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public  static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    /**
                     * uniqueInstance = new Singleton(); 是分为三步执行
                     *
                     * 1.为 uniqueInstance 分配内存空间
                     * 2.初始化 uniqueInstance
                     * 3.将 uniqueInstance 指向分配的内存地址
                     *
                     * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。
                     *
                     * 多线程可能有问题，使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
                     */
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}

