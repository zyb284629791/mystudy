package com.john.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-19 14:32
 */
public class UnSafeDataTest {

    public static void main(String[] args) throws InterruptedException {
        UnSafeData unSafeData = new UnSafeData();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(unSafeData);
            thread.start();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
