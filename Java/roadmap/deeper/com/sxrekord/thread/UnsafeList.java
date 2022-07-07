package com.sxrekord.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rekord
 * @date 2022/7/6 18:07
 */
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        int runCount = 10000;
        for (int i= 0; i < runCount; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}

/**
 * 可能出现多个线程操作同一个元素的情况，故最终大小 < runCount;
 * 同步 list 即可解决该问题
 */
