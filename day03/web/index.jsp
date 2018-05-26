<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/5/26
  Time: 08:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();

%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
Hello World! This is day03 <br>
<%=path %><br>
<%--静态包含（翻译时）--%>
<%@include file="inner.jsp" %><br>
<a href="StudentListServlet">查看学生列表</a>
</body>
</html>
