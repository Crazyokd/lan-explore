<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="/ex8/handle-servlet">
            
            <table align="center" border="1">
                <th colspan="2">用户登录</th>
                <tr>
                    <td>用户名：</td>
                    <td><input name="username"/></td>
                </tr>
                <tr><td>密码：</td><td><input name="password"/></td></tr>
            <tr><td colspan="2" align="center"><input type="submit"></td></tr>
            </table>
        </form>
</body>
</html>