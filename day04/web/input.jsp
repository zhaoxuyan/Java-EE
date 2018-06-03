<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/6/3
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="show.jsp">
    真实姓名：<input name="realname" title=""><br>
    身份证号：<input name="idno" title=""><br>
    性别：
    男<input type="radio" name="gender" value="男" title="">
    女<input type="radio" name="gender" value="女" title=""><br>
    爱好：
    看书<input type="checkbox" name="hobbies" value="看书" title="">
    购物<input type="checkbox" name="hobbies" value="购物" title="">
    游泳<input type="checkbox" name="hobbies" value="游泳" title=""><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
