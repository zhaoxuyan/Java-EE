<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/5/12
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>登录</h2>
<form method="get" action="${pageContext.request.contextPath}/LoginServlet">
    用户名: <input name="username" title=""> <br>
    密码：<input type="password" name="userpwd" title=""> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
