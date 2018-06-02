<%@ page import="com.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/3
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    table {
        border: 1px solid gray;
        border-collapse: collapse;
        width: 40%
    }

    td {
        border: 1px solid gray;
    }
</style>


</head>

<body>

<h1>查看学生信息</h1>
<table>
    <tr>
        <td>编号</td>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
    </tr>
    <tr>
        <%
            Student s = (Student) request.getAttribute("students");
        %>
        <td><%=s.getId()%>
        </td>
        <td><%=s.getStuno()%>
        </td>
        <td><%=s.getStuname()%>
        </td>
        <td><%=s.getStusex()%>
        </td>
        <td><%=s.getStuyear() %>
        </td>
    </tr>

</table>

</body>
</html>
