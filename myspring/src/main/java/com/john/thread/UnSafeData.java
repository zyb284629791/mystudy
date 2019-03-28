package com.john.thread;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-19 14:32
 */
public class UnSafeData implements Runnable {

    private LocalDateTime localDateTime;

    @Override
    public void run() {
        localDateTime = LocalDateTime.now();
        System.out.printf("线程 %s 开始时间：%s \n", Thread.currentThread().getId(), localDateTime);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("线程 %s 执行结束，开始时间是：%s \n", Thread.currentThread().getId(), localDateTime);
    }
}
