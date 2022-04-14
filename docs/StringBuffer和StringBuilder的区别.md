# StringBuffer和StringBuilder的区别

## 一、概览

StringBuffer和StringBuilder都继承自AbstractStringBuilder，StringBuffer是线程安全的，StringBuilder是线程不安全的。为什么这样呢？

## 二、例子

首先看一个例子：

```java
public class StringDemo {

    // 请求总数
    private static int clientTotal = 500;

    private static StringBuilder stringBuilder = new StringBuilder();

    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {

        testStringBuilder();
        testStringBuffer();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("stringBuilder长度" + stringBuilder.length());
        System.out.println("stringBuffer长度" + stringBuffer.length());
    }

    public static void testStringBuilder() {
        // stringBuilder
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < clientTotal; i1++) {
                    stringBuilder.append("1");
                }
            }).start();
        }
    }

    public static void testStringBuffer() {
        // stringBuffer
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < clientTotal; i1++) {
                    stringBuffer.append("1");
                }
            }).start();
        }
    }
}
```

**简单说明：**

开启主线程，``testStringBuilder()``和``testStringBuffer()``方法分别循环十次，每次新建500个线程，每个线程在字符串后面追加1，主线程休眠5秒，输出最后各自的长度。

理论上，每个方法都新建了5000个线程，得到的长度应该为5000才对。实际输出结果如下：

```java
stringBuilder长度4989
stringBuffer长度5000
```

可以看出StringBuilder长度不等于5000，这里面有线程安全问题。

## 三、StringBuilder为什么是线程不安全的？

### 3.1 源码分析

查看StringBuilder的append(str)方法源码：

```java
@Override
public StringBuilder append(String str) {
    super.append(str);
    return this;
}
```

调用了父类的AbstractStringBuilder：

```java
public AbstractStringBuilder append(String str) {
    if (str == null)
        return appendNull();
    int len = str.length();
    ensureCapacityInternal(count + len);
    str.getChars(0, len, value, count);
    count += len;
    return this;
}
```

> 步骤详情：

1、如果传过来的字符串是null，走``appendNull()``方法，在字符串里追加``null``，长度加4；

```java
private AbstractStringBuilder appendNull() {
    int c = count;
    ensureCapacityInternal(c + 4);
    final char[] value = this.value;
    value[c++] = 'n';
    value[c++] = 'u';
    value[c++] = 'l';
    value[c++] = 'l';
    count = c;
    return this;
}
```

2、不是null，获取传过来的str的长度，调用``ensureCapacityInternal(count + len)``方法，传入的是当前长度加上这次要追加的字符串str的长度，确保容量足够。

```java
private void ensureCapacityInternal(int minimumCapacity) {
    // overflow-conscious code
    if (minimumCapacity - value.length > 0) {
        value = Arrays.copyOf(value,
                newCapacity(minimumCapacity));
    }
}
```

如果当前数组长度不够放新追加的字符串了，需要扩容，扩容代码：

```java
private int newCapacity(int minCapacity) {
    // overflow-conscious code
    int newCapacity = (value.length << 1) + 2;
    if (newCapacity - minCapacity < 0) {
        newCapacity = minCapacity;
    }
    return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
        ? hugeCapacity(minCapacity)
        : newCapacity;
}
```

先预设新的长度为当前长度的两倍再加2，``(value.length << 1)``左移一位，就是乘以2的意思。如果没超过的话就拉倒了。如果新需要的容量已经超过了最大值，变成负数了，或者已经超过了``MAX_ARRAY_SIZE``也就是``Integer.MAX_VALUE - 8;``那么进入``hugeCapacity``()方法；

```java
private int hugeCapacity(int minCapacity) {
    if (Integer.MAX_VALUE - minCapacity < 0) { // overflow
        throw new OutOfMemoryError();
    }
    return (minCapacity > MAX_ARRAY_SIZE)
        ? minCapacity : MAX_ARRAY_SIZE;
}
```

如果超过最大值，抛异常OutOfMemoryError，没有的话，判断是否大于``Integer.MAX_VALUE ``但是小于``Integer.MAX_VALUE - 8``，如果是的话，返回当前需要的容量，如果不是的话，返回Integer.MAX_VALUE - 8；

自此，扩容结束并赋值到新开辟的数组上。

### 3.2 数组越界问题

在执行上面的例子的时候，容易出现一个错误，如下：

```java
Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException
	at java.lang.System.arraycopy(Native Method)
	at java.lang.String.getChars(String.java:826)
```

也就是数组越界问题，举例如下：

初始化``StringBuilder``的时候，char[]数组的长度为16，源码如下：

```java
public StringBuilder() {
    super(16);
}
```

hi,boy

hi,girl

``count += len;``这行代码，如果有两个线程A，B，本来的长度count=100，线程A加一次字符串"1"，长度变为101，B线程再加一次字符串"1"，长度变为102，这是理想的预设情况，没有问题。假如