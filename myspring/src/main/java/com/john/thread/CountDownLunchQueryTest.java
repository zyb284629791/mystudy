package com.john.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-19 15:46
 */
public class CountDownLunchQueryTest {

    public static void main(String[] args) throws InterruptedException {

        int totalPage = 5;
        CountDownLunchQuery countDownLunchQuery = new CountDownLunchQuery(totalPage);
        for (int i = 0; i < totalPage; i++) {
            Thread thread = new Thread(countDownLunchQuery);
            thread.start();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
