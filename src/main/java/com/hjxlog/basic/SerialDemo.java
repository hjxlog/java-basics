package com.hjxlog.basic;

import java.io.Serializable;

/**
 * @author Huang JX
 * @date 2022/4/5
 * @description 序列化
 */
public class SerialDemo implements Serializable {

    //transient 只能修饰变量，不能修饰类和方法。
    //阻止实例中那些用此关键字修饰的的变量序列化
    private transient String id;

    private String name;

}
