package test;

public class AspectJTest {
    public void before(){System.out.println("before!"); }
    public void after(){System.out.println("after!"); }

}


//1 面向切面编程的应用
//
//        需求描述:
//        PersonInf: 定义一个操作数据常用的四个方法的接口
//        PersonSQLImp：实现PersonInf类，是操作SQL数据库的一个具体类
//        Dog:定义两个方法的接口类
//        GunDog:实现了Dog接口类
//
//        如果现在要求在调用PersonInf和GunDog接口的每个方法之前和之后都加入日志来跟踪调试。
//
