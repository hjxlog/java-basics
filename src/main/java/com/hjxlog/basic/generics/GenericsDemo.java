package com.hjxlog.basic.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang JX
 * @date 2022/4/11
 * @description
 */
public class GenericsDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("a");
        // list.add(1); // 编译时检查
        Class<? extends List> aClass = list.getClass();
        // 通过反射获取add方法
        Method add = aClass.getDeclaredMethod("add", Object.class);
        // 调用add方法，传入1参数
        add.invoke(list, 1);
        System.out.println(list); //[a, 1]

    }

}
