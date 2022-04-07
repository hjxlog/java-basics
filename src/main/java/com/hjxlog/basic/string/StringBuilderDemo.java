package com.hjxlog.basic.string;

/**
 * @Author: Huang JX
 * @Date: 2022/04/07
 * @Description:
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("aa");
        String str = null;
        stringBuilder.append(str);
        // 添加null
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
    }

}
