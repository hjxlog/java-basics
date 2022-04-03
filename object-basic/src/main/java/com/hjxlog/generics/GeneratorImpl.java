package com.hjxlog.generics;

/**
 * @author Huang JX
 * @date 2022/4/3
 * 和泛型类一样<T>
 *     实现泛型接口，不指定类型
 */
class GeneratorImpl<T> implements Generator<T>{
    @Override
    public T method() {
        return null;
    }
}

