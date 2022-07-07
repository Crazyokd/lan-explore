package com.sxrekord.thread;

/**
 * @author Rekord
 * @date 2022/7/6 17:32
 */
public class PriorityTest {
    public static void main(String[] args) {
        // default priority
        System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());
    }
}
// MAX_PRIORITY 10
// NORM_PRIORITY 5
// MIN_PRIORITY 1