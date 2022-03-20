package main.java;

public class Test {
    public static void main(String args[]){
        new SaleWindow("窗口1").start();
        new SaleWindow("窗口2").start();
        new SaleWindow("窗口3").start();
    }
}
class SaleWindow extends Thread{
    private String windowName;
    private static Object lock=new Object();//作为同步锁
    private static int ticket=10;//所有售票窗口共享余票
    public SaleWindow(){}
    public SaleWindow(String windowName){
        this.windowName=windowName;
    }
    @Override
    public void run(){
        while(true){
            //为了避免异步写或者脏读，需要同步售卖过程
            synchronized(lock){
                if(!sale())break;
            }
            try {
                sleep((int)Math.random()*30);//模拟窗口售票的随机性
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 若还有余票，就售出一张票并打印余票数量。
     * @return  无余票返回false，否则返回true
     */
    public Boolean sale(){
        if(ticket>0){
            ticket-=1;
            System.out.println(windowName+"售卖了一张票,目前还剩下"+ticket+"张票");
            return true;
        }
        return false;
    }
}
