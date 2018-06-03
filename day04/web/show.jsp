<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/3
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>真实姓名：${param.realname}</div>
<div>身份证号：${param.idno}</div>
<div>性别：${param.gender}</div>
<%--<div>爱好(返回的是一个数组)：${paramValues.hobbies}</div>--%>
爱好：
<%--老方法--%>
<%--<%--%>
    <%--String hobbies[] = request.getParameterValues("hobbies");--%>
    <%--for (String hobby : hobbies) {--%>
        <%--out.println(hobby);--%>
    <%--}--%>
<%--%>--%>



</body>
</html>
