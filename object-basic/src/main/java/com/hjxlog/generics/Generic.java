package com.hjxlog.generics;

/**
 * @author Huang JX
 * @date 2022/4/
 * 泛型类
 */
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T> {
    private T key;
    public Generic(T key) {
        this.key = key;
    }
    public T getKey() {
        return key;
    }

    public static void main(String[] args) {
        // 在实例化泛型类时，必须指定T的具体类型
        Generic<String> generic = new Generic<>("hello");
        System.out.println(generic.getKey());

    }

}

