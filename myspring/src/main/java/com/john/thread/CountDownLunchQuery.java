package com.john.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-19 15:37
 */
public class CountDownLunchQuery implements Runnable {

    private CountDownLatch countDownLatch;

    public CountDownLunchQuery(int page) {
        this.countDownLatch = new CountDownLatch(page);
    }

    @Override
    public void run() {
        try {
            System.out.printf("Starting Thread:%s : page %s\n", Thread.currentThread().getId(),countDownLatch.getCount());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Finish Thread:%s : page %s\n", Thread.currentThread().getId(), countDownLatch.getCount());
        } finally {
            countDownLatch.countDown();
        }
    }
}
