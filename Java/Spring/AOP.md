# AOP
## 概念
1. 什么是 AOP
- （1）面向切面编程（方面），利用 AOP 可以对业务逻辑的各个部分进行隔离，从而使得
业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。
- （2）通俗描述：不通过修改源代码方式，在主干功能里面添加新功能
- （3）使用登录例子说明 AOP
![example](images/图3.png)
## 底层原理
1. AOP 底层使用动态代理
- （1）有两种情况动态代理
    * 第一种 有接口情况，使用 JDK 动态代理
        > 创建接口实现类代理对象，增强类的方法
    * 第二种 没有接口情况，使用 CGLIB 动态代理
        > 创建子类的代理对象，增强类的方法

![example](images/图4.png)

## JDK动态代理
1. 使用 JDK 动态代理，使用 Proxy 类里面的方法创建代理对象
- （1）调用 newProxyInstance 方法

    方法有三个参数：

    第一参数，类加载器

    第二参数，增强方法所在的类，这个类实现的接口，支持多个接口

    第三参数，实现这个接口 InvocationHandler，创建代理对象，写增强的部分

2. 编写 JDK 动态代理代码
- （1）创建接口，定义方法
```java
public interface UserDao {
 public int add(int a,int b);
 public String update(String id);
}
```
- （2）创建接口实现类，实现方法
```java
public class UserDaoImpl implements UserDao {
 @Override
 public int add(int a, int b) {
 return a+b;
 }
 @Override
 public String update(String id) {
 return id;
 }
}
```
- （3）使用 Proxy 类创建接口代理对象
```java
public class JDKProxy {
 public static void main(String[] args) {
 //创建接口实现类代理对象
 Class[] interfaces = {UserDao.class};
// Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces,
new InvocationHandler() {
// @Override
// public Object invoke(Object proxy, Method method, Object[] args)
throws Throwable {
// return null;
// }
// });
 UserDaoImpl userDao = new UserDaoImpl();
 UserDao dao =
(UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces,
new UserDaoProxy(userDao));
 int result = dao.add(1, 2);
 System.out.println("result:"+result);
 }
}
//创建代理对象代码
class UserDaoProxy implements InvocationHandler {
 //1 把创建的是谁的代理对象，把谁传递过来
 //有参数构造传递
 private Object obj;
 public UserDaoProxy(Object obj) {
 this.obj = obj;
 }
 //增强的逻辑
 @Override
 public Object invoke(Object proxy, Method method, Object[] args) throws
Throwable {
 //方法之前
 System.out.println("方法之前执行...."+method.getName()+" :传递的参
数..."+ Arrays.toString(args));
 //被增强的方法执行
 Object res = method.invoke(obj, args);
 //方法之后
 System.out.println("方法之后执行...."+obj);
 return res;
 }
}
```
