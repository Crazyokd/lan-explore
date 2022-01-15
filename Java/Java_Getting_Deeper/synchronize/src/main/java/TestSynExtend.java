package main.java;

public class TestSynExtend {

    public static void main(String[] args) {
//        SynExtendA a = new SynExtendA();
//        new Thread(a).start();
//        new Thread(a).start();
//        new Thread(a).start();

        SynExtendB b=new SynExtendB();
        Thread t1=new Thread(b);
        t1.setName("b1");
        t1.start();
        Thread t2=new Thread(b);
        t2.setName("b2");
        t2.start();
        Thread t3=new Thread(b);
        t3.setName("b3");
        t3.start();
    }
}

class SynExtendA extends Thread{
    public static int total=0;
    @Override
    public void run() {
        test();
    }
    //编写一个同步方法
    synchronized public void test(){
            System.out.print(currentThread().getName()+":");
            for(int i=0;i<5;i++,total+=1)
                System.out.print(total+" ");
            System.out.println();
    }
}
class SynExtendB extends SynExtendA{
    @Override
    public void run() {
        test();
    }
//    public void test(){
//        System.out.print(currentThread().getName()+":");
//        for(int i=0;i<5;i++,total+=1)
//            System.out.print(total+" ");
//        System.out.println();
//    }
}