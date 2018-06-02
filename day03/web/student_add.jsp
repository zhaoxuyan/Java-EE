<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/2
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>学生信息</h1>
<form action="StudentAddServlet" method="post">
    <input type="text" name="id" placeholder="编号">
    <input type="text" name="stuno" placeholder="学号">
    <input type="text" name="name" placeholder="姓名">
    <input type="text" name="gender" placeholder="性别">
    <input type="text" name="age" placeholder="年龄">
    <button type="submit">提交</button>
</form>
</body>
</html>
