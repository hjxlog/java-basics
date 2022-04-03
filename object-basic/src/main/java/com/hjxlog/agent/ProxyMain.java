package com.hjxlog.agent;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class ProxyMain {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());

        /**
         * 当我们的动态代理对象调用原生方法的时候，
         * 最终实际上调用到的是 invoke() 方法，
         * 然后 invoke() 方法代替我们去调用了被代理对象的原生方法。
         */
        smsService.send("java");

    }
}
