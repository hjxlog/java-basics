package com.hjxlog.thread.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: Huang JX
 * @Date: 2022/04/14
 * @Description:
 */
public class CountDownLatchDemo {
    private final static Random random = new Random();

    static class SearchTask implements Runnable {
        private Integer id;
        private CountDownLatch latch;

        public SearchTask(Integer id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("开始寻找" + id + "号龙珠");
            int seconds = random.nextInt(10);
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("花了" + seconds + "s,找到了" + id + "号龙珠");
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        List<Integer> idList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        CountDownLatch latch = new CountDownLatch(idList.size());
        for (Integer id : idList) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread thread = new Thread(new SearchTask(id, latch));
                    thread.start();
                }
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("找到所有龙珠，开始召唤神龙");
    }

}
