package com.hjxlog.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Huang JX
 * @date 2022/4/12
 * @description 实现Callable接口的方式创建线程，实现call()方法
 */
public class CallerTask implements Callable {

    /**
     * V call() throws Exception;
     * 有返回值，可以抛出异常
     */
    @Override
    public String call() throws Exception {
        return "hello";
    }

    public static void main(String[] args) {
        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        // 启动线程
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
