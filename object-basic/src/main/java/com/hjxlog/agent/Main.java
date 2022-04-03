package com.hjxlog.agent;

/**
 * @author Huang JX
 * @date 2022/4/3
 * 静态代理
 *
 */
public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}

