> 注意：执行与构建过程相关的Maven命令时，必须进入pom.xml所在的目录执行。
>>    与构建过程相关：编译、测试、打包、......
## 常用命令
- 清理：mvn clean
- 编译主程序：mvn compile
- 编译测试程序：mvn test-compile
- 执行测试：mvn test
- 执行打包：mvn package
- 上传项目至：mvn install
- 生成站点：mvn site

## 关于联网问题
1. Maven的核心程序中仅仅定义了抽象的生命周期，但是具体的工作必须由特定的插件来完成。
而插件本身并不包含在Maven的核心程序中。
2. 当我们执行的Maven命令需要用到某些插件时，Maven核心程序会首先到本地仓库中查找。
3. 本地仓库的默认位置：【系统中当前用户的家目录】/.m2/repository
4. Maven核心程序如果在本地仓库中找不到指定的插件，会尝试通过网络到中央仓库下载。
5. 如果此时无法联网，则构建失败。
6. 修改默认本地仓库的位置可以让Maven核心程序到我们事先准备好的目录中查找。
    1. 找到Maven的解压目录\config\settings.xml
    2. 在settings.xml文件中找到<localRepository>标签
    3. 将localRepository的值修改为我们准备好的目录
7. 如果我们想要让Maven核心程序到中央仓库中查找，可以在Maven配置文件中添加以下配置：
```shell
<settings>
    <servers>
        <server>
            <id>central</id>
            <username>username</username>
            <password>password</password>
            <url>http://central.maven.org/maven2/</url>
        </server>
    </servers>
</settings>
```

```shell
mvn clean install
mvn clean test
mvn clean package
```