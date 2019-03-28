package com.john.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 张彦斌
 * @Date: 2019-03-19 14:59
 */
public class PageQueryTest {

    public static void main(String[] args) throws InterruptedException {
        PageQuery pageQuery = new PageQuery();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(pageQuery);
            pageQuery.setPage(Long.valueOf(i));
            thread.start();
//            TimeUnit.SECONDS.sleep(1);
        }
    }
}
