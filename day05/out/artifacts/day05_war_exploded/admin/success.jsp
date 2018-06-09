<%--
  Created by IntelliJ IDEA.
  User: zhaoxuyan
  Date: 2018/5/19
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
    <%--// 判断session是否有用户名，如果无此步骤，可绕过登录直接访问success.jsp--%>
    <%--String name = (String) session.getAttribute("current_username");--%>
    <%--if (name == null) {--%>
        <%--// 保存错误信息--%>
        <%--request.setAttribute("error_message", "您忘了登录哦~！");--%>
        <%--// 非法访问 跳转到登录界面--%>
        <%--request.getRequestDispatcher("login.jsp").forward(request, response);--%>
    <%--}--%>
<%--%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎光临！${current_username}<br>
<a href="LogoutServlet">退出登录</a>
</body>
</html>
