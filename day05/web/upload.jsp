<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/9
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UploadServlet" method="post"
      enctype="multipart/form-data">
    <input type="file" name="f1"><br>
    <input type="file" name="f1"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
