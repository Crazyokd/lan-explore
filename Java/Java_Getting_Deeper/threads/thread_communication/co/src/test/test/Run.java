package test.test;

//往list中增加一个字符串元素

import java.util.ArrayList;
import java.util.List;

class ValueObject {

    public static List list=new ArrayList();

}

class Add {

    private String lock;

    public Add(String lock){

        this.lock=lock;

    }

    public void add(){

        synchronized(lock){

            ValueObject.list.add("anyString");

            lock.notifyAll();

        }

    }

}

//删除list中的一个元素

class Subtract {

    private String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }

    public void subtract() {

        try {

            synchronized (lock) {

                if (ValueObject.list.size() == 0) {

                    lock.wait();

                }
                if(ValueObject.list.size()!=0)
                ValueObject.list.remove(0);

                System.out.println("list size=" + ValueObject.list.size());

            }

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }
}

//增加List中元素的线程

class ThreadAdd extends Thread{

    private Add p;

    public ThreadAdd(Add p){this.p=p;}

    public void run(){

        p.add();

    }
}

//删除list中的一个元素的线程

class ThreadSubtract extends Thread{

    private Subtract c;


    public ThreadSubtract(Subtract c){

        this.c=c;

    }

    public void run(){

        c.subtract();

    }
}
public class Run {

    public static void main(String[] args)throws InterruptedException {

        String lock=new String("");

        Add add=new Add(lock);

        Subtract sub=new Subtract(lock);

        ThreadAdd addThread=new ThreadAdd(add);

        ThreadSubtract subThread1=new ThreadSubtract(sub);

        subThread1.setName("subtract1Thread");

        ThreadSubtract subThread2=new ThreadSubtract(sub);

        subThread2.setName("subtract2Thread");

        subThread1.start();

        subThread2.start();

        Thread.sleep(1000);

        addThread.start();

    }

}




