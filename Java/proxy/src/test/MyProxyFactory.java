package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxyFactory {

    public static Object getProxy(Object proxy){
        return Proxy.newProxyInstance(
                proxy.getClass().getClassLoader(),// 传入ClassLoader
                proxy.getClass().getInterfaces(), // 传入要实现的接口
                new ProxyHandler(proxy)); // 传入处理调用方法的InvocationHandler
        }

}
class ProxyHandler implements InvocationHandler{
    private Object object;
    public ProxyHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        AspectJTest aspectJTest=new AspectJTest();
        aspectJTest.before();
        method.invoke(object, args);
        aspectJTest.after();
        return null;
    }
}