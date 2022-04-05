package com.hjxlog.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description 反射
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /**
         * 获取Class对象
         */
        Class<?> targetClass = Class.forName("com.hjxlog.basic.TargetObj");
        /**
         * 实例化
         */
        TargetObj targetObj = (TargetObj)targetClass.newInstance();

        // 获取所有的方法
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        /**
         * 获取指定方法调用
         * 获取Method，再调用Method.invoke
         */
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObj, "hello world");

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        // 私有方法，直接调用会报 can not access a member of class
        privateMethod.setAccessible(true); // 设置setAccessible
        privateMethod.invoke(targetObj);
    }

}
