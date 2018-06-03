<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/3
  Time: 08:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>今天是是第四次课</h1>
  <%
    request.setAttribute("uname","admin");
    request.getRequestDispatcher("main.jsp?pwd=123&state=110").forward(request,response);
  %>

  </body>
</html>
