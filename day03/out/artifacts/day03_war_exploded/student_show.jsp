<%@ page import="java.util.List" %>
<%@ page import="com.entity.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: servlet
  Date: 2018/5/26
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<style type="text/css">
    table {
        border: 1px solid gray;
        border-collapse: collapse;
        width: auto;
    }

    td {
        border: 1px solid gray;
    }

</style>
<%
    // 从request中取出集合
    List<Student> list = (List<Student>) request.getAttribute("students");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>操作</td>
    </tr>
    <%
        if(list != null){
            for(Student s : list){
    %>
    <tr>
        <td><%=s.getId() %></td>
        <td><%=s.getStuno() %></td>
        <td><%=s.getStuname() %></td>
        <td><%=s.getStusex() %></td>
        <td><%=s.getStuyear() %></td>
        <td><a href="StudentDelServlet?id=<%=s.getId() %>">删除</a>
            <a href="">修改</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
