package test;

class ObjectValueService{

//    private String lock ="123";
    private TestThread lock=new TestThread(0);
    public  void testMethod(){
        try{
            synchronized(lock){
                System.out.println(Thread.currentThread().getName()+
                        "  begin "+System.currentTimeMillis());
                //改变lock对象的值
//                lock="456";
                lock.test=1;
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+
                        "  end "+System.currentTimeMillis());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}



public class RunObjectValue {

    public static void main(String[] args) throws InterruptedException{
        ObjectValueService object = new ObjectValueService();
        ObjectValueThread  a  = new ObjectValueThread(object);
        a.setName("A");
        ObjectValueThread  b  = new ObjectValueThread(object);
        b.setName("B");
        a.start();
        Thread.sleep(50);
        b.start();
    }
}

class ObjectValueThread extends Thread {

    private ObjectValueService service;
    public ObjectValueThread(ObjectValueService s){
        super();
        this.service = s;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
class TestThread{
    protected int test=0;
    public TestThread(int test){
        super();
        this.test=test;
    }
}