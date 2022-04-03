package com.hjxlog.generics;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
class Generator02Impl implements Generator<String>{
    @Override
    public String method() {
        return "hello";
    }

    public static void main(String[] args) {
        Generator02Impl generator02 = new Generator02Impl();
        String method = generator02.method();
        System.out.println(method);
    }
}

