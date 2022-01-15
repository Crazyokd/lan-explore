<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
    </head>
    <body>
        <h1 align="center">用户注册</h1>
        <hr align="center"/>
        <form method="post" action="/ex8/reg-servlet">
            <div>
                <div align="center">用户名：<input name="username"/></div>
                <div align="center">密码：<input name="password"/></div>
                <div align="center"><input type="submit" value="注册"/></div>
            </div>
        </form>
    </body>
</html>