<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/5/19
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="color: red;">
    ${error_message}
</div>
<form method="post" action="${pageContext.request.contextPath}/UserServlet">
    用户名: <input name="username" title=""> <br>
    密码：<input type="password" name="userpwd" title=""> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
