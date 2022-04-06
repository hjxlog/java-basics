package com.hjxlog.basic;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description 包装类 的常量池技术，所有的包装类型，用equals()方法判断相等
 * 总结：
 * 1. Byte Short Integer Long 常量池范围：[-128,127]
 * 2. Float Double 没有常量池技术，直接new Float()
 * 3. Character 范围：[0,127]
 * 4. Boolean 范围：[true,false]
 */
public class ConstantPool {
    public static void main(String[] args) {
        // 源码的valueOf方法
        // Byte Short Integer Long 包装类，[-128,127]
        System.out.println("=====integer=====");
        /**
         * 源码
         *     public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         */
        Integer integer1 = 1;
        Integer integer2 = 1;
        System.out.println(integer1 == integer2); //true
        System.out.println("integer1 - hashcode" + integer1.hashCode());
        System.out.println("integer2 - hashcode" + integer2.hashCode());
        System.out.println(integer1.equals(integer2));//true

        System.out.println("=====float=====");
        /**
         * 源码
         *     public static Float valueOf(float f) {
         *         return new Float(f);
         *     }
         */
        // 两种浮点数类型的包装类 Float,Double 并没有实现常量池技术。
        Float float1 = 123f;
        Float float2 = 123f;
        System.out.println(float1 == float2);

        System.out.println("=====double=====");
        Double double1 = 100d;
        Double double2 = 100d;
        System.out.println(double1 == double2);


        System.out.println("=====Character=====");
        // Character的常量池缓存范围[0,127]
        Character character1 = 127;
        Character character2 = 127;
        System.out.println(character1.equals(character2));//true
        System.out.println(character1 == character2); //true

        System.out.println("=====String=====");
        String str1 = "aa";
        String str2 = "aa";
        System.out.println(str1 == str2); // true
        String str3 = new String("aa");
        System.out.println(str2 == str3); //false

        System.out.println("=====Boolean=====");
        /**
         * 源码
         *     public static Boolean valueOf(boolean b) {
         *         return (b ? TRUE : FALSE);
         *     }
         */
        Boolean boolean1 = true;
        Boolean boolean2 = true;
        System.out.println(boolean1 == boolean2); // true
    }
}
