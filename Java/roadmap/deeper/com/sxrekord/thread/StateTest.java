package com.sxrekord.thread;

/**
 * @author Rekord
 * @date 2022/7/6 15:14
 */
public class StateTest{
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int runCount = 5;
            for (int i = 0; i < runCount; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " run over.");
        });

        // 观察线程状态
        Thread.State state = thread.getState();
        System.out.println("before start method, state = " + state);

        thread.start();
        System.out.println("after start method, state = " + (state = thread.getState()));

        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("before terminated, state = " + (state = thread.getState()));
        }
    }
}

/**
 * 线程死亡后不能再被启动
 */