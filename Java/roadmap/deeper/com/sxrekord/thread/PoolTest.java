package com.sxrekord.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Rekord
 * @date 2022/7/7 10:09
 */
public class PoolTest {
    public static void main(String[] args) {
        // 1. 创建服务
        ExecutorService service = Executors.newFixedThreadPool(5);

        // 2. 执行
        MyThread thread = new MyThread();
        service.execute(thread);
        service.execute(thread);
        service.execute(thread);
        service.execute(thread);

        // 3. 关闭连接
        service.shutdown();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
