<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/5/19
  Time: 09:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 获取全部cookie,保存cookie后，访问首页时自动登录（3，7，30天）
    Cookie[] cookie = request.getCookies();
    String name = null, pwd = null;
    // 遍历
    for (Cookie c : cookie) {
        if (c.getName().equals("username")) {
            name = c.getValue();

        }
        if (c.getName().equals("userpwd")) {
            pwd = c.getValue();
        }
    }
    if (name != null && pwd != null) {
        // get 提交
        request.getRequestDispatcher("UserServlet?username=" + name + "&" + "userpwd=" + pwd)
                .forward(request, response);
    }
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
网站首页
</body>
</html>
