package test;


public class Bank{
    private static ThreadLocal<Integer> account = new ThreadLocal<Integer>() {

        @Override

        protected Integer initialValue() {	return 100;}

    };

    public synchronized void deposit(int money) {	account.set(account.get() + money);}

    public int getAccount() {return account.get();}
    public static void main(String[] args) throws InterruptedException{
        Bank bank=new Bank();
        Deposit d1=new Deposit(bank);
        Deposit d2=new Deposit(bank);
        d1.start();
        d2.start();
        d1.join();
        d2.join();
        System.out.println("d1:"+d1.bank.getAccount()+"\nd2:"+d2.bank.getAccount());
    }
}
class Deposit extends Thread{
    Bank bank;
    public Deposit(Bank bank){
        super();
        this.bank=bank;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            this.bank.deposit(10);
            System.out.println(Thread.currentThread().getName()+":"+this.bank.getAccount());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.bank.getAccount());
    }

}

