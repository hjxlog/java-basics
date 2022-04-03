package com.hjxlog.generics;

/**
 * @author Huang JX
 * @date 2022/4/3
 * 泛型方法
 */
public class GeneratorFun {

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        GeneratorFun generatorFun = new GeneratorFun();
        String[] arr = new String[]{"a","b","c"};
        generatorFun.printArray(arr);
    }
}
