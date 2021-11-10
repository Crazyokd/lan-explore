package test;

import java.util.Random;
//假设有一颗蟠桃树，初始有100颗桃子，每隔300毫秒就随机结出若干蟠桃，数目是一个10以内的随机数。
//每隔500毫秒有一个仙女就会来蟠桃园数一次桃子的数目。
//        孙悟空每隔100毫秒就会偷吃掉这个蟠桃数上的一个桃子。
//        请编写一个程序，模拟孙悟空吃桃子、仙女摘桃子和蟠桃数结桃子的行为。请问你的设计先简单说明一下，给出代码必要的注释。
public class Test2 {
    public static int peachNum=100;
    public static void main(String[] args){
        //仙女数桃子
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("仙女数了一遍，发现目前有" + peachNum + "个逃子");
                }
            }
        }).start();
        //大圣吃桃子
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    peachNum -= 1;
                    System.out.println("大圣又偷吃了一个桃子");
                }
            }
        }).start();
        //蟠桃树结桃子
        Random random = new Random();
        while(true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int newPeach=Math.abs(random.nextInt()) % 10 + 1;
            peachNum+=newPeach;
            System.out.println("蟠桃树新结出了"+newPeach+"个桃子");
        }
    }
}
