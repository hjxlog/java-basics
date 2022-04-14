package com.hjxlog.basic.string;

/**
 * @Author: Huang JX
 * @Date: 2022/04/07
 * @Description:
 */
public class StringBuilderDemo {

    private StringBuffer stringBuffer;

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hi,");
        stringBuilder.append("boy");
        String str = null;
        stringBuilder.append(str);
        // 添加null
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());

        StringBuilderDemo stringBuilderDemo = new StringBuilderDemo();
        stringBuilderDemo.append();

    }

    public StringBuilderDemo append() {
        System.out.println(this);
        // 返回当前对象
        return this;
    }

}
