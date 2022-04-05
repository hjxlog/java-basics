package com.hjxlog.basic;

import java.lang.annotation.Target;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description
 */
public class TargetObj {

    private String value;

    public TargetObj() {
    }

    public TargetObj(String value) {
        this.value = value;
    }

    public void publicMethod(String str) {
        System.out.println("public方法...");
        System.out.println(str);
    }

    private void privateMethod() {
        System.out.println("private方法...");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
