package com.sxrekord.thread;

/**
 * @author Rekord
 * @date 2022/7/6 17:36
 */
public class DaemonTest implements Runnable{
    @Override
    public void run() {
        while(true) {
            System.out.println("daemon...");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonTest());
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            while (true) {
                System.out.println("run...");
            }
        }).start();
    }
}

/**
 * 守护线程在所有线程死亡后自动死亡
 */
