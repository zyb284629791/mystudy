package com.john.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-19 14:41
 */
public class SafeDataTest {

    public static void main(String[] args) throws InterruptedException {
        SafeData safeData = new SafeData();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(safeData);
            thread.start();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
