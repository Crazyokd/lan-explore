package com.sxrekord.thread;

/**
 * @author Rekord
 * @date 2022/7/6 14:39
 */
public class YieldTest implements Runnable{
    @Override
    public void run() {
        int runCount = 10;
        for (int i = 0; i < runCount; i++) {
            System.out.println(Thread.currentThread().getName() + "线程开始执行");
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "线程终止执行");
        }
    }
    public static void main(String[] args) {
        new Thread(new YieldTest()).start();

        // 补偿一些线程初始化时间
        int compensateTime = 15;
        try {
            Thread.sleep(compensateTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread run...");
        }
    }
}

/**
 * 将线程从运行状态转为就绪状态
 */
