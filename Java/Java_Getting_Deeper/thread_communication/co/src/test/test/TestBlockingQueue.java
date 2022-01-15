package test.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

//4 使用BlockingQueue实现线程通信
//        模拟多条生产者线程往固定大小的缓冲区放入数据，多条生产者线程往同样的缓冲区读取数据的操作。
//        当缓冲区的已满，生成者线程不能往缓冲区放入数据，当缓冲区没有数据时，不能往缓冲区读数据。
public class TestBlockingQueue {
    public static BlockingQueue<String> bq = new LinkedBlockingDeque<>(4);
    public static void main(String[] args){
        PutThread pt = new PutThread(bq);
        getThread gt = new getThread(bq);

        for (int i=0;i < 5;i++){
            new Thread(pt,"putthread" + i).start();
            new Thread(gt,"getthread" + i).start();
        }
    }
}

class PutThread extends Thread {

    private BlockingQueue<String> bq;

    public PutThread(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        try {
            String data =Thread.currentThread().getName() + "放置的数据" ;
            System.out.println(Thread.currentThread().getName() + "放置了一个数据" );
            bq.put(data);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class getThread extends Thread {

    private BlockingQueue<String> bq;

    public getThread(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        try {
            String data = bq.take();
            System.out.println(Thread.currentThread().getName() + "拿取了"+data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}