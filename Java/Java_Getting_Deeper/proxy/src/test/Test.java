package test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//        【提交代码和运行界面】创建三个线程对象，他们的任务如下：
//        第一个线程任务计算1到100整数的和，并返回计算的和(要求Callable 实现)。
//        第二个线程任务打印字母a 100次
//        第三个线程任务打印字母b 100 次
//        请编写测试的代码中，按照顺序依次启动线程（要求输出第一个线程计算的和的结果）。
public class Test {
    public static void main(String args[]) {
        //创建callable对象
        CallableTest call=new CallableTest();
        FutureTask<Integer> fu=new FutureTask<Integer>(call);
        new Thread(fu).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++)
                    System.out.print("a");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++)
                    System.out.print("b");
            }
        }).start();

        //得到返回值
        try {
            System.out.println("返回值是:" + fu.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class CallableTest implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int ans=0;
        for(int i=1;i<=100;i++){
            ans+=i;
        }
        return ans;
    }
}





