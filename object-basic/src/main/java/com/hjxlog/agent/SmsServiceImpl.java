package com.hjxlog.agent;

/**
 * @author Huang JX
 * @date 2022/4/3
 */
public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
