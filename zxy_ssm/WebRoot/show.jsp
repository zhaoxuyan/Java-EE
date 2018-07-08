<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
</head>
<body>
<table border="1" width="100%">
    <tr>
        <th>编号</th>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
    </tr>
    <c:forEach items="${stu }" var="a">
        <tr>
            <td>${a.id }</td>
            <td>${a.stuno }</td>
            <td>${a.name }</td>
            <td>${a.age }</td>
            <td>${a.gender }</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>