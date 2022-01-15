package test;
//join方法，等待调用线程死亡
public class Test {
    public static void main(String args[]) throws InterruptedException {
        Thread thread2=new PrintThread('a');
        Thread thread3=new PrintThread('b');

        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=1;i<=100;i++)
                    System.out.print(i);
            }
        });
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
class PrintThread extends Thread{
    private char letter;
    public PrintThread(){

    }
    public PrintThread(char letter){
        this.letter=letter;
    }
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.print(letter);
            if(i==50){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}