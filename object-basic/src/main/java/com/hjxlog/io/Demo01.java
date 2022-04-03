package com.hjxlog.io;

import java.io.Serializable;

/**
 * @author Huang JX
 * @date 2022/4/3
 * 序列化的主要目的是通过网络传输对象或者说是将对象存储到文件系统、数据库、内存中。
 */
public class Demo01 implements Serializable {

    //对于不想进行序列化的变量，使用 transient 关键字修饰。
    //transient 修饰的变量，在反序列化后变量值将会被置成类型的默认值。例如，如果是修饰 int 类型，那么反序列后结果就是 0。
    private transient int id;

    /**
     * static 变量因为不属于任何对象(Object)，
     * 所以无论有没有 transient 关键字修饰，均不会被序列化。
     */
    private static String password;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Demo01.password = password;
    }
}
