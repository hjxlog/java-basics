package com.hjxlog;

/**
 * @author Huang JX
 * @date 2022/4/2
 */
public class StringDemo {

    public static void main(String[] args) {
        /**
         *     @Override
         *     public synchronized StringBuffer append(Object obj) {
         *         toStringCache = null;
         *         super.append(String.valueOf(obj));
         *         return this;
         *     }
         *     用synchronized修饰，加锁，线程安全
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abc");

        /**
         *     @Override
         *     public StringBuilder append(char[] str) {
         *         super.append(str);
         *         return this;
         *     }
         *     没有加锁
         */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("def");

        String[] arr = {"he", "llo", "world"};
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        System.out.println(s);
        // javap -c -v -s -l xxx.class  查看反编译信息
    }

}
