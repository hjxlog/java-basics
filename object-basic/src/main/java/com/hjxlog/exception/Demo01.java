package com.hjxlog.exception;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class Demo01 {

    public static void main(String[] args) {
        System.out.println(f(2));
    }

    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }

}
