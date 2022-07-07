package com.sxrekord.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Rekord
 * @date 2022/7/6 22:22
 */
public class LockTest implements Runnable{
    private ReentrantLock lock = new ReentrantLock();

    int ticketNum = 10;
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticketNum > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNum--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockTest lt = new LockTest();

        new Thread(lt).start();
        new Thread(lt).start();
        new Thread(lt).start();
    }
}

/**
 * 1. 性能更好
 * 2. 扩展性更好（子类更多）
 */
