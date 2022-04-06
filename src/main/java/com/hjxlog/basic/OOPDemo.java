package com.hjxlog.basic;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description 多态，可以是继承父类或者实现接口
 * 总结：
 * 1. 继承：子类拥有父类对象所有的属性和方法，但是父类中的私有属性和方法子类是无法访问，只是拥有。
 * 2. 封装：不暴露变量，对外提供功能
 * 3. 多态：继承或者接口，向上转型，等到具体运行的时候，才知道调用的是谁
 */
public class OOPDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        /**
         * animal.name  不可以这样访问，名称是私有的：private String name;
         * 不可以直接操作名称，安全，提供对外访问的方法，set get
         */
        animal.setName("动物"); // 封装

        // 多态
        Pig pig = new Pig();
//        pig.name  不能这样直接调用父类的私有属性
        pig.setName("小猪"); // 继承父类的属性方法，调用
        System.out.println("猪的名字：" + pig.getName());
        fun(pig);
        eat(pig);

        Rabbit rabbit = new Rabbit();
        fun(rabbit);
        eat(rabbit);
    }

    static void fun(Animal animal) {
        animal.sound();
    }

    static void eat(Animal animal) {
        animal.eat();
    }

}

class Animal implements IEatFood {

    private String name; // 名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Animal setName方法，名字：" + name);
        this.name = name;
    }

    public void sound() {
        System.out.println("动物发出叫声...");
    }

    @Override
    public void eat() {
        System.out.println("动物吃东西...");
    }
}

class Pig extends Animal implements IEatFood {

    @Override
    public void sound() {
        System.out.println("猪发出叫声...");
    }

    @Override
    public void eat() {
        System.out.println("猪吃猪食...");
    }
}

class Rabbit extends Animal implements IEatFood {
    @Override
    public void sound() {
        System.out.println("兔子发出叫声...");
    }

    @Override
    public void eat() {
        System.out.println("兔子吃胡萝卜...");
    }
}

interface IEatFood {
    void eat();
}