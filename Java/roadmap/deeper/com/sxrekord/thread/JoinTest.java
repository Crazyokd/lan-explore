package com.sxrekord.thread;

/**
 * @author Rekord
 * @date 2022/7/6 14:54
 */
public class JoinTest implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new JoinTest());
        // not below line, no effect
        thread.start();

        // open another thread
        new Thread(new JoinTest()).start();

        int runCount = 50;
        for (int i = 0; i < runCount; i++) {
            System.out.println("main thread run...");
            if (i == runCount/2) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        int runCount = 10;
        for (int i = 0; i < runCount; i++) {
            System.out.println(Thread.currentThread().getName() + " run...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 1. 调用 join 的线程对象必须已经调用过 start 方法，即该线程在此之前已经被激活。
 * 2. 调用 join 方法后，并不会阻塞所有线程，仅阻塞调用处所在线程。
 */