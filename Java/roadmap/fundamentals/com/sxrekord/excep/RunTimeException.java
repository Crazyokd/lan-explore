package com.sxrekord.excep;

/**
 * @author Rekord
 * @date 2022/6/23 19:50
 */
public class RunTimeException {
    public void f(Object obj) throws NullPointerException {
        System.out.println(obj.getClass());
    }

    public void g(Object object) {
        f(object);
    }

    public static void main(String[] args) {
        RunTimeException runTimeException = new RunTimeException();
        runTimeException.g(new Exception());
        runTimeException.g(null);
    }
}

/// output
/*
class java.lang.Exception
Exception in thread "main" java.lang.NullPointerException
	at com.sxrekord.excep.RunTimeException.f(RunTimeException.java:9)
	at com.sxrekord.excep.RunTimeException.g(RunTimeException.java:13)
	at com.sxrekord.excep.RunTimeException.main(RunTimeException.java:19)
 */

/*
此例中说明 运行时异常 即使显示声明，也不需要进行检查
 */