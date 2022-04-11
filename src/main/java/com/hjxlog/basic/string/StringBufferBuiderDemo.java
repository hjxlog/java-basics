package com.hjxlog.basic.string;

/**
 * @Author: Huang JX
 * @Date: 2022/04/07
 * @Description: StringBuffer 和 StringBuilder的线程安全测试
 * 总结：
 * 1. StringBuffer和StringBuilder都继承自AbstractStringBuilder
 * 2. StringBuffer是线程安全的，加了synchronized
 * 3. StringBuilder是线程不安全的
 */
public class StringBufferBuiderDemo {

    // 请求总数
    private static int clientTotal = 500;

    private static StringBuilder stringBuilder = new StringBuilder();

    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {

        testStringBuilder();
        testStringBuffer();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("stringBuilder长度" + stringBuilder.length());
        System.out.println("stringBuffer长度" + stringBuffer.length());
    }

    public static void testStringBuilder() {
        // stringBuilder
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < clientTotal; i1++) {
                    stringBuilder.append("1");
                }
            }).start();
        }
    }

    public static void testStringBuffer() {
        // stringBuffer
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < clientTotal; i1++) {
                    stringBuffer.append("1");
                }
            }).start();
        }
    }
}
