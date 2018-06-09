package com.zhaoxuyan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取输入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("userpwd");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);

        // 用户名密码验证
        if (username.equals("123") && password.equals("123")) {
            // 将用户名保存在session中，在success.jsp中通过${current_username}使用
            HttpSession session = request.getSession();
            session.setAttribute("current_username", username);
            request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
        } else {
            // 跳转到失败页面
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }

    }
}
