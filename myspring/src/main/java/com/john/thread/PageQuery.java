package com.john.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-19 14:55
 */
public class PageQuery implements Runnable {

    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    private long page;

    public void setPage(Long page) {
        this.page = page;
    }

    @Override
    public void run() {
        threadLocal.set(page);
        System.out.printf("Starting Thread:%s : page %s\n", Thread.currentThread().getId(), threadLocal.get());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Finish Thread:%s : page %s\n", Thread.currentThread().getId(), threadLocal.get());
    }
}
