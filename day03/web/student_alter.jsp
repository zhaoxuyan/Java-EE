<%@ page import="com.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/3
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>修改学生信息</h2>
<form action="StudentAlterServlet" method="post">
    <table>
        <%
            Student s=(Student)request.getAttribute("students");
        %>
        <tr><td>编号</td>
            <td><input type="text" name="id" value="<%=s.getId() %>"  title=""></td></tr>
        <tr><td>学号</td>
            <td><input type="text" name="stuno" value="<%=s.getStuno()%>" title=""></td></tr>
        <tr><td>姓名</td>
            <td><input type="text" name="name" value="<%=s.getStuname() %>" title=""></td></tr>
        <tr><td>性别</td>
            <td><input type="text" name="gender" value="<%=s.getStusex()%>" title=""></td></tr>
        <tr><td>年龄</td>
            <td><input type="text" name="age" value="<%=s.getStuyear()%>" title=""></td></tr>
        <tr><td colspan="2">
            <input type="submit" value="提交"></td></tr>
    </table>
</form>
</body>
</html>
