package com.hjxlog.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class Demo01 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 提供编译时的安全检测机制
        List<Integer> list = new ArrayList<>();
        list.add(12);
        //这里直接添加会报错
        //list.add("a");
        // 通过反射机制
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加是可以的
        //这就说明在运行期间所有的泛型信息都会被擦掉
        add.invoke(list, "kl");
        System.out.println(list);

    }

}
