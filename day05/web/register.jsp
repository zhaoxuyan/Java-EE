<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/9
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>注册</h1>
<form action="${pageContext.request.contextPath}/RegisterServlet" method="post" enctype="multipart/form-data">
    用户名：<input name="uname" title=""><br>
    密码：<input name="upwd" title=""><br>
    头像：<input type="file" name="headimg"><br>
    <input type="submit" value="提交" ><br>
    <%--<input type="button" onclick="window.location.href='admin/success.jsp';" value="注册">--%>
</form>
</body>
</html>
