<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/3
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="zxy" uri="http://mycompany.com" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>主页</h1>
<div>
    <%--脚本--%>
    <%
    String val = (String) request.getAttribute("uname");
    if (val != null && !val.equals("")) {
    %><span style="color: red; "><%=val%></span> <%
    }
    %>

    <%--tld形式--%>
    <%--<zxy:printRegAttr attr="uname"/>--%>

    <%--<span  style="color: red; ">${requestScope.uname}</span>--%>
    <span style="color: red; ">${uname}</span>
</div>
<div>密码：${param.pwd}</div>
<div>状态码：${param.state}</div>
</body>
</html>
