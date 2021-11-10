package test.test;

public class Test {
    public static void main(String[] args){
        Clock clock=new Clock();
        //启动三个线程，分别调用三个方法
        new TestClock(clock){
            @Override
            public void carry(){
                this.clock.addSecond();
            }
        }.start();
        new TestClock(clock){
            @Override
            public void carry(){
                this.clock.addMinute();
            }
        }.start();
        new TestClock(clock){
            @Override
            public void carry(){
                this.clock.addHour();
            }
        }.start();
    }
}


class Clock{
    int second,minute,hour;
    boolean carrySecond=false;
    boolean carryMinute=false;
    public Clock(){
        this.second=this.minute=this.hour=0;
    }
    public void addSecond(){
        if(!carryMinute){
            //输出时间
            System.out.println(this.hour + ":" + this.minute + ":" + this.second);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.second = (this.second + 1) % 60;
            if (this.second == 0) {
                this.carrySecond = true;
//                System.out.println("秒钟准备休眠");
                toggle();
            }
        }else{
            toggle();
        }
    }
    public void addMinute(){
        if(carrySecond){
            this.minute=(this.minute+1)%60;
            carrySecond=false;
            if(this.minute==0){
                this.carryMinute=true;
                toggle();
            }
        }else{
//                    System.out.println("分钟准备休眠");
            toggle();
        }
    }
    public void addHour(){
        if(carryMinute){
            this.hour+=1;
            carryMinute=false;
        }else{
            toggle();
        }
    }

    //线程切换
    public void toggle(){
        this.notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestClock extends Thread{
    Clock clock;
    public TestClock(Clock clock){
        super();
        this.clock=clock;
    }
    @Override
    public void run(){
        synchronized (this.clock) {
            while (true) {
                carry();
            }
        }
    }
    public void carry(){
        //重写有效
    }
}