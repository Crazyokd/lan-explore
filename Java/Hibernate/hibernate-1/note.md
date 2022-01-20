## 创建持久化Java类
- 提供一个无参的构造器:
> 使Hibernate可以使用Constructor.newInstance() 来实例化持久化类
- 提供一个标识属性(identifier property): 
> 通常映射为数据库表的主键字段. 如果没有该属性，一些功能将不起作用，如：Session.saveOrUpdate()
- 为类的持久化类字段声明访问方法(get/set): 
> Hibernate对JavaBeans 风格的属性实行持久化。
- 使用非 final 类: 
> 在运行时生成代理是 Hibernate 的一个重要的功能. 如果持久化类没有实现任何接口, Hibnernate 使用 CGLIB 生成代理. 如果使用的是 final 类, 则无法生成 CGLIB 代理.
- 重写 eqauls 和 hashCode 方法: 
> 如果需要把持久化类的实例放到 Set 中(当需要进行关联映射时), 则应该重写这两个方法

## HelloWorld
使用 Hibernate 进行数据持久化操作，通常有如下步骤：
- 编写持久化类： POJO + 映射文件
- 获取 Configuration 对象
- 获取 SessionFactory 对象
- 获取 Session，打开事务
- 用面向对象的方式操作数据库
- 关闭事务，关闭 Session

## 1. Session:

1. 对 Session 缓存的理解

2. Session 的 API 方法:
```
save,persist,saveOrUpdate
update, merge
get,load -- get 和 load 的区别
delete

close
flush
refresh
clear

evict
```
3. Transaction: 

commit() -- commit 和  flush 的区别

4. 在持久化的角度对象的 4 种状态, 以及转换. 

5. session.doWork(): 可以获取到 JDBC 原生的 Connection 对象.

## 2. hibernate.cfg.xml:

配置 C3P0 数据库连接池

## 3. .hbm.xml:

1. ID 生成器: increment, identity, sequence, hilo, native

2. property 的  not-null, unique, length, index, formula, type

3. 如何映射 java.util.Date 类型的属性

4. property 的 column 子节点, 其中有一个 sql-type 属性. 