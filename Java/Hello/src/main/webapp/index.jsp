<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<h1 align="center">Beer Selection</h1>
<form method="post" action="hello-servlet">
    <p align="center">Select beer characteristics</p>
    <p align="center">Color:
    <select name="color" size="1">
        <option value="light">light</option>
        <option value="amber">amber</option>
        <option value="brown">brown</option>
        <option value="dark">dark</option>
    </select>
    </p>
    <br><br>
    <center>
        <input type="submit">
    </center>
</form>
</body>
</html>