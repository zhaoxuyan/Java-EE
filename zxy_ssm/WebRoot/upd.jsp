<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
    学生基本信息
</head>
<body>
<table border="1" width="100%">
    <c:forEach items="${stu }" var="a">
    <tr>
        <td>
            <form action="studentUpd.action" method="post">
                编号<input name="id" value="${a.id }"><br>
                学号<input name="stuno" value="${a.stuno }"><br>
                姓名<input name="name" value="${a.name }"><br>
                性别<input name="gender" value="${a.gender }"><br>
                年龄<input name="age" value="${a.age }"><br>
                <input type="submit" value="确认修改">
            </form>
        </td>
        </c:forEach>
</table>
</body>
</html>