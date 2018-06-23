<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/23
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<table border="1" width="100%">
  <tr>
    <th>sid</th>
    <th>name</th>
    <th>age</th>
    <th>sal</th>
    <th>birthday</th>
  </tr>
  <c:forEach items="${list }" var="a">
    <tr>
      <td>${a.sid }</td>
      <td>${a.name }</td>
      <td>${a.age }</td>
      <td>${a.sal }</td>
      <td>${a.birthday }</td>
    </tr>
  </c:forEach>
</table>
</body>

