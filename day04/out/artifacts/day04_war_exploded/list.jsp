<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/3
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>成年/未成年</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="stu">
        <tr>
            <td>${stu.stuno}</td>
            <td>${stu.stuname}</td>
            <td>${stu.stusex}</td>
            <td>${stu.stuyear}</td>
            <td>
                <%--if else--%>
                <c:choose>
                    <c:when test="${stu.stuyear >= 18}">
                        成年
                    </c:when>
                    <c:otherwise>
                        <span style="color: red; ">未成年</span>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
