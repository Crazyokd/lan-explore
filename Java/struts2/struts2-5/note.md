## 1. Action 实现 ModelDriven 接口后的运行流程

1). 先会执行 ModelDrivenInterceptor 的 intercept 方法. 
```java
    public String intercept(ActionInvocation invocation) throws Exception {
    	//获取 Action 对象: EmployeeAction 对象, 此时该 Action 已经实现了 ModelDriven 接口
    	//public class EmployeeAction implements RequestAware, ModelDriven<Employee>
        Object action = invocation.getAction();

		//判断 action 是否是 ModelDriven 的实例
        if (action instanceof ModelDriven) {
        	//强制转换为 ModelDriven 类型
            ModelDriven modelDriven = (ModelDriven) action;
            //获取值栈
            ValueStack stack = invocation.getStack();
            //调用 ModelDriven 接口的 getModel() 方法
            //即调用 EmployeeAction 的 getModel() 方法
            /*
            public Employee getModel() {
				employee = new Employee();
				return employee;
			}
            */
            Object model = modelDriven.getModel();
            if (model !=  null) {
            	//把 getModel() 方法的返回值压入到值栈的栈顶. 实际压入的是 EmployeeAction 的 employee 成员变量
            	stack.push(model);
            }
            if (refreshModelBeforeResult) {
                invocation.addPreResultListener(new RefreshModelBeforeResult(modelDriven, model));
            }
        }
        return invocation.invoke();
    }
```
2). 执行 ParametersInterceptor 的 intercept 方法: 把请求参数的值赋给栈顶对象对应的属性. 若栈顶对象没有对应的属性, 则查询
值栈中下一个对象对应的属性...

3). 注意: getModel 方法不能提供以下实现. 的确会返回一个 Employee 对象到值栈的栈顶. 但当前 Action 
的 employee 成员变量却是 null. 
```java
public Employee getModel() {
	return new Employee();
}    
```
## 2. 使用 paramsPrepareParamsStack 拦截器栈后的运行流程

1). paramsPrepareParamsStack 和 defaultStack 一样都是拦截器栈. 而 struts-default 包默认使用的是 defaultStack

2). 可以在 Struts 配置文件中通过以下方式修改使用的默认的拦截器栈
```xml
<default-interceptor-ref name="paramsPrepareParamsStack"></default-interceptor-ref>
```
3). paramsPrepareParamsStack 拦截器在于

params -> modelDriven -> params

所以可以先把请求参数赋给 Action 对应的属性, 再根据赋给Action 的那个属性值决定压到值栈栈顶的对象, 最后再为栈顶对象的属性赋值.

对于 edit 操作而言:

- I.   先为 EmployeeAction 的 employeeId 赋值

- II.  根据 employeeId 从数据库中加载对应的对象, 并放入到值栈的栈顶

- III. 再为栈顶对象的 employeeId 赋值(实际上此时 employeeId 属性值已经存在)

- IV.  把栈顶对象的属性回显在表单中.

4). 关于回显: Struts2 表单标签会从值栈中获取对应的属性值进行回显. 

5). 存在的问题: 
```java
getModel 方法

public Employee getModel() {
	if(employeeId == null)
		employee = new Employee();
	else
		employee = dao.get(employeeId);
	
	return employee;
}
```
- I.   在执行删除的时候, employeeId 不为 null, 但 getModel 方法却从数据库加载了一个对象. 不该加载!
- II.  指向查询全部信息时, 也 new Employee() 对象. 浪费!

6). 解决方案: 使用 PrepareInterceptor 和 Preparable 接口. 

7). 关于 PrepareInterceptor

[分析后得到的结论]
 
若 Action 实现了 Preparable 接口, 则 Struts 将尝试执行 prepare[ActionMethodName] 方法,
若 prepare[ActionMethodName] 不存在, 则将尝试执行 prepareDo[ActionMethodName] 方法.
若都不存在, 就都不执行.

若 PrepareInterceptor  的 alwaysInvokePrepare 属性为 false, 
则 Struts2 将不会调用实现了 Preparable 接口的  Action 的 prepare() 方法

[能解决 5) 的问题的方案]

可以为每一个 ActionMethod 准备 prepare[ActionMethdName] 方法, 而抛弃掉原来的 prepare() 方法
将 PrepareInterceptor  的 alwaysInvokePrepare 属性置为 false, 以避免 Struts2 框架再调用 prepare() 方法.

如何在配置文件中为拦截器栈的属性赋值: 参看 /struts-2.3.15.3/docs/WW/docs/interceptors.html
```xml
<interceptors>
    <interceptor-stack name="parentStack">
        <interceptor-ref name="defaultStack">
            <param name="params.excludeParams">token</param>
        </interceptor-ref>
    </interceptor-stack>
</interceptors>
 
<default-interceptor-ref name="parentStack"/>
```
----------------------------------源代码解析---------------------------------
```java
public String doIntercept(ActionInvocation invocation) throws Exception {
	//获取 Action 实例
    Object action = invocation.getAction();

	//判断 Action 是否实现了 Preparable 接口
    if (action instanceof Preparable) {
        try {
            String[] prefixes;
            //根据当前拦截器的 firstCallPrepareDo(默认为 false) 属性确定 prefixes
            if (firstCallPrepareDo) {
                prefixes = new String[] {ALT_PREPARE_PREFIX, PREPARE_PREFIX};
            } else {
                prefixes = new String[] {PREPARE_PREFIX, ALT_PREPARE_PREFIX};
            }
            //若为 false, 则 prefixes: prepare, prepareDo
            //调用前缀方法.
            PrefixMethodInvocationUtil.invokePrefixMethod(invocation, prefixes);
        }
        catch (InvocationTargetException e) {

            Throwable cause = e.getCause();
            if (cause instanceof Exception) {
                throw (Exception) cause;
            } else if(cause instanceof Error) {
                throw (Error) cause;
            } else {
                throw e;
            }
        }

		//根据当前拦截器的 alwaysInvokePrepare(默认是 true) 决定是否调用 Action 的 prepare 方法
        if (alwaysInvokePrepare) {
            ((Preparable) action).prepare();
        }
    }

    return invocation.invoke();
}
```

PrefixMethodInvocationUtil.invokePrefixMethod(invocation, prefixes) 方法:

```java
public static void invokePrefixMethod(ActionInvocation actionInvocation, String[] prefixes) throws InvocationTargetException, IllegalAccessException {
	//获取 Action 实例
	Object action = actionInvocation.getAction();
	//获取要调用的 Action 方法的名字(update)
	String methodName = actionInvocation.getProxy().getMethod();
	
	if (methodName == null) {
		// if null returns (possible according to the docs), use the default execute 
        methodName = DEFAULT_INVOCATION_METHODNAME;
	}
	
	//获取前缀方法
	Method method = getPrefixedMethod(prefixes, methodName, action);
	
	//若方法不为 null, 则通过反射调用前缀方法
	if (method != null) {
		method.invoke(action, new Object[0]);
	}
}
```
PrefixMethodInvocationUtil.getPrefixedMethod 方法: 
```java
public static Method getPrefixedMethod(String[] prefixes, String methodName, Object action) {
	assert(prefixes != null);
	//把方法的首字母变为大写
	String capitalizedMethodName = capitalizeMethodName(methodName);
    
    //遍历前缀数组
    for (String prefixe : prefixes) {
        //通过拼接的方式, 得到前缀方法名: 第一次 prepareUpdate, 第二次 prepareDoUpdate
        String prefixedMethodName = prefixe + capitalizedMethodName;
        try {
        	//利用反射获从 action 中获取对应的方法, 若有直接返回. 并结束循环.
            return action.getClass().getMethod(prefixedMethodName, EMPTY_CLASS_ARRAY);
        }
        catch (NoSuchMethodException e) {
            // hmm -- OK, try next prefix
            if (LOG.isDebugEnabled()) {
                LOG.debug("cannot find method [#0] in action [#1]", prefixedMethodName, action.toString());
            }
        }
    }
	return null;
}
```