package test;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod{
    public static void main(String[] args) throws Exception{
        Object[] s={};
        System.out.println(executeMethod("test.Student","f1",s));
        String[] ss={"have a s"};
        System.out.println(executeMethod("test.Student","f1",ss));
        Object[] sss={"s",200};
        System.out.println(executeMethod("test.Student","f1",sss));

    }
    public static Object executeMethod(String className, String methodName, Object args[]) throws ClassNotFoundException,
            InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class c=Class.forName(className);
        Object obj=c.getConstructor().newInstance();

        Method[] ms=c.getDeclaredMethods();
        for(Method m:ms){
            if(m.getName().equals(methodName)&&m.getParameterCount()==args.length){
                m.setAccessible(true);
                System.out.println(m);
                return m.invoke(c.getConstructor().newInstance(),args);
            }
        }
        return null;
    }
}
