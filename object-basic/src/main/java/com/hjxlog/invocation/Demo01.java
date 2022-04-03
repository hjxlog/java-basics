package com.hjxlog.invocation;

/**
 * @author Huang JX
 * @date 2022/4/3
 * 获取四种Class对象的方式
 */
public class Demo01 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 知道具体类的情况下可以使用：
        Class<Demo01> aClass = Demo01.class;

        // 通过 Class.forName()传入类的全路径获取：
        Class<?> aClass1 = Class.forName("com.hjxlog.invocation.Demo01");

        // 通过对象实例instance.getClass()获取：
        Demo01 demo01 = new Demo01();
        Class<? extends Demo01> aClass2 = demo01.getClass();

        //通过类加载器xxxClassLoader.loadClass()传入类路径获取:
//        Class clazz = ClassLoader.loadClass("cn.javaguide.TargetObject");
        
        // 反射的基本操作
        Demo01 demo011 = aClass.newInstance();
        System.out.println(demo011);


    }

}
