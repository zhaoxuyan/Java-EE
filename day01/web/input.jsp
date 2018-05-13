<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/5/12
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>学生信息收集</h2>
<%--get提交会显示数据,post不会，更安全--%>
<form method="get" action="${pageContext.request.contextPath}/Input">
    姓名:<input type="text" title="" name="username"> <br>
    身份证号：<input type="text" name="id" title=""> <br>
    性别：
    <input type="radio" name="gender" value="男" title="">男
    <input type="radio" name="gender" value="女" title="">女 <br>
    国籍：<select name="list" title="">
    <option value="中国">中国</option>
    <option value="委内瑞拉">委内瑞拉</option>
    <option value="美国">美国</option>
    <option value="朝鲜">朝鲜</option>
    </select> <br>
    添加图片<input type="file"> <br>
    <input type="submit" value="提交信息"> <br>

</form>
</body>
</html>
