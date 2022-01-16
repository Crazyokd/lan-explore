## IOC(BeanFactory接口)
1. IOC 思想基于 IOC 容器完成，IOC 容器底层就是对象工厂
2. Spring 提供 IOC 容器实现两种方式：（两个接口）
    - BeanFactory：IOC 容器基本实现，是 Spring 内部的使用接口，不提供开发人员进行使用
    
        **加载配置文件时候不会创建对象，在获取对象（使用）才去创建对象**
    - ApplicationContext：BeanFactory 接口的子接口，提供更多更强大的功能，一般由开发人
员进行使用

        **加载配置文件时候就会把在配置文件对象进行创建**
3. ApplicationContext 接口实现类
    - FileSystemXmlApplicationContext
    - ClassPathXmlApplicationContext