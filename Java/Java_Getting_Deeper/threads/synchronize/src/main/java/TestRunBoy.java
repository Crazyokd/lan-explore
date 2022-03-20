package main.java;

public class TestRunBoy{
    public static void main(String[] args){
        //猜想过使用线程优先级表示速度，但不同架构的线程优先级表示范围不同，故放弃该想法
        new RunBoy("于洋",6).start();
        new RunBoy("李晨",7).start();;
        new RunBoy("郑凯",8).start();;
        new RunBoy("沙溢",5).start();;
        new RunBoy("宋雨琦",4).start();;
        new RunBoy("杨颖",3).start();;
        new RunBoy("白鹿",2).start();;
        new RunBoy("周湖翔",8).start();//增加答案的多样性
        new RunBoy("彭龙泽",8).start();//增加答案的多样性
    }
}
class RunBoy extends Thread{
    private String name;
    private int speed;
    private int distance;
    private static Integer totalDistance=200;//既可以作为终点距离又可以作为同步锁
    private static boolean isOver=false;

    public RunBoy(){}
    public RunBoy(String name,int speed){
        this.name=name;
        this.speed=speed;
        this.distance=0;
    }
    @Override
    public void run() {
        while(true){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(isOver) break;
            distance+=speed;
            if(distance>=totalDistance){
                synchronized (totalDistance) {
                    //同步锁内加一次判断方能真正保证线程安全
                    if(!isOver) {
                        isOver = true;
                        System.out.println(this.name + "第一个到达终点");
                    }
                }
            }
        }

    }
}
