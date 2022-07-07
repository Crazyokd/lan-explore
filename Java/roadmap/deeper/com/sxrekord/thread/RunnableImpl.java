package com.sxrekord.thread;

import java.util.concurrent.*;

/**
 * @author Rekord
 * @date 2022/7/6 11:32
 */
public class RunnableImpl implements Runnable{

    @Override
    public void run() {
        System.out.println("RunnableImpl run method.");
    }
}

class RunnableImplTest {
    public static void main(String[] args) {
        new Thread(new RunnableImpl()).start();
    }
}

class CallableTest implements Callable {
    @Override
    public Boolean call() {
        System.out.println("CallableTest call method");
        return true;
    }

    public static void main(String[] args) {
        CallableTest c1 = new CallableTest();
        CallableTest c2 = new CallableTest();
        CallableTest c3 = new CallableTest();

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> f1 = ser.submit(c1);
        Future<Boolean> f2 = ser.submit(c2);
        Future<Boolean> f3 = ser.submit(c3);

        // 获取结果
        try {
            boolean result1 = f1.get();
            boolean result2 = f2.get();
            boolean result3 = f3.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭服务
        ser.shutdownNow();

    }
}

/** Callable
 * 1. 可以定义返回值
 * 2. 可以抛出异常
 */