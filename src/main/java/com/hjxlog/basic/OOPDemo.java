package com.hjxlog.basic;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description 多态，可以是继承父类或者实现接口
 */
public class OOPDemo {
    public static void main(String[] args) {
        // 多态
        Pig pig = new Pig();
        fun(pig);
        eat(pig);

        Rabbit rabbit = new Rabbit();
        fun(rabbit);
        eat(rabbit);
    }

    static void fun(Animal animal){
        animal.sound();
    }

    static void eat(Animal animal){
        animal.eat();
    }

}

class Animal implements IEatFood{
    public void sound(){
        System.out.println("动物发出叫声...");
    }

    @Override
    public void eat() {
        System.out.println("动物吃东西...");
    }
}

class Pig extends Animal implements IEatFood{
    @Override
    public void sound() {
        System.out.println("猪发出叫声...");
    }

    @Override
    public void eat() {
        System.out.println("猪吃猪食...");
    }
}

class Rabbit extends Animal implements IEatFood{
    @Override
    public void sound() {
        System.out.println("兔子发出叫声...");
    }

    @Override
    public void eat() {
        System.out.println("兔子吃胡萝卜...");
    }
}

interface IEatFood{
    void eat();
}