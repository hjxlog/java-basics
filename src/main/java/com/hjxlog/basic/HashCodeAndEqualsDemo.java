package com.hjxlog.basic;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description
 */
public class HashCodeAndEqualsDemo {

    public static void main(String[] args) {
        // 很多是native方法，本地方法，用C或者C++实现的
        Object object = new Object();
        // 获取hashcode值，代表在哈希表中的位置
        int hashCode = object.hashCode();
        System.out.println("hashCode:" + hashCode);

        /**
         * ==
         *  1. 对于基本数据类型，比较的是值
         *  2. 对于引用类型，比较的是地址值
         */
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        System.out.println("cat1 == cat2 ? :" + (cat1 == cat2));

        Cat cat3 = new Cat("花猫");
        Cat cat4 = new Cat("花猫");
        System.out.println("cat3.equals(cat4) : " + cat3.equals(cat4));

        HashSet catHashSet = new HashSet();
        catHashSet.add(cat3);
        catHashSet.add(cat4);
        // 如果重写equals没有重写hashcode，就是两个对象，因为hashcode不一致，直接判定为不同的对象，这就有问题了！
        System.out.println(catHashSet); // [com.hjxlog.basic.Cat@7f31245a, com.hjxlog.basic.Cat@14ae5a5]

        Dog dog1 = new Dog("大黄");
        Dog dog2 = new Dog("大黄");
        System.out.println(dog1.equals(dog2));
        HashSet dogHashSet = new HashSet();
        dogHashSet.add(dog1);
        dogHashSet.add(dog2);
        System.out.println(dogHashSet); //[com.hjxlog.basic.Dog@b6a9c]
    }

}

class Cat {

    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 首先判断地址是不是一样的，是的话就直接true
        if (o == null || getClass() != o.getClass()) return false; // 判断是不是同一类型的，不是的话直接false
        Cat cat = (Cat) o;  // 类型强转
        return name.equals(cat.name); // 比较名字
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}

class Dog {

    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return name.equals(dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // 调用Objects.hash
    }
}