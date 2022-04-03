package com.hjxlog.exception;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class Demo02 {
    public static void main(String[] args) {
        fun();
    }

    public static void fun(){
        try {
            System.out.println("Try to do something");
            throw new RuntimeException("RuntimeException");
        } catch (Exception e) {
            System.out.println("Catch Exception -> " + e.getMessage());
            // 终止当前正在运行的Java虚拟机
            System.exit(1);
        } finally {
            System.out.println("Finally");
        }

    }
}
