package com.sxrekord.thread;

// 管程法解决生产者消费者问题
/**
 * @author Rekord
 * @date 2022/7/6 22:53
 */
public class TestPC {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();

    }
}

class Producer implements Runnable{
    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            buffer.push(new Product());
            if (i == 12) {
                break;
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("producer produce " + i++ + " product.");
        }
    }
}

class Consumer implements Runnable{
    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            Product product = buffer.pop();
            System.out.println("consumer consume " + ++i + " product.");
        }
    }
}

class Product {}
class Buffer {
    public static final int MAX_CAPACITY = 10;
    Product[] products = new Product[MAX_CAPACITY];

    int count = 0;

    public synchronized void push(Product product) {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (count == MAX_CAPACITY) {
            // 通知消费者
            try {
                this.notify();
                this.wait();
                System.out.println("after producer wait 1.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products[count++] = product;
        System.out.println("after producer wait 2.");
    }

    public synchronized Product pop() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (count == 0) {
            // 通知生产者生产
            try {
//                this.notify();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return products[--count];
    }
}

/**
 * 1. wait 方法执行后，同步方法或同步代码块内后面的代码将不会再被执行，但同步方法或同步代码块外的代码仍然会继续执行
 * 2，只有在当前线程真正陷入到阻塞状态或终止状态时，被唤醒线程才真正被唤醒
 * 3. wait 和 notify 都是 Object 对象的方法
 */