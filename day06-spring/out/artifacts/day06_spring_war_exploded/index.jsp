<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/23
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<table border="1" width="100%">
    <tr>
        <th>id</th>
        <th>stuno</th>
        <th>stuname</th>
        <th>stusex</th>
        <th>year</th>
    </tr>
    <c:forEach items="${list}" var="a">
        <tr>
            <td>${a.id }</td>
            <td>${a.stuno }</td>
            <td>${a.stuname }</td>
            <td>${a.stusex }</td>
            <td>${a.year }</td>
        </tr>
    </c:forEach>
</table>
</body>

