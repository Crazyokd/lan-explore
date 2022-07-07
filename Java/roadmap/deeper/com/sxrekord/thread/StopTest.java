package com.sxrekord.thread;

/**
 * @author Rekord
 * @date 2022/7/6 12:50
 */
public class StopTest implements Runnable{
    private boolean flag = true;

    @Override
    public void run() {
        while(flag) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " thread run...");
        }
    }

    public void stop() {
        flag = false;
    }

    public static void main(String[] args) {
        StopTest st = new StopTest();
        new Thread(st, "ts").start();

        for (int i = 0; i < 100; i++) {
            if (i >= 90) {
                st.stop();
                System.out.println("stop ts thread");
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main thread run...");
        }
    }
}

/**
 * 1. 通过自定义方法来停止线程
 * 2. 不要使用 stop 方法或 destroy 方法
 */