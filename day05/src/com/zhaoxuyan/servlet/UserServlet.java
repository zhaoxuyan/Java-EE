package com.zhaoxuyan.servlet;

import com.zhaoxuyan.entity.User;
import com.zhaoxuyan.service.UserService;

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

        UserService service = new UserService();
        User currUser = null;
        try {
            currUser = service.login(username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(currUser != null) {
            //将用户名保存在session中
            HttpSession session = request.getSession();
            session.setAttribute("currUser", currUser);
            request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
        }else{
            //跳转到失败页面
            response.sendRedirect("fail.jsp");
        }

    }
}
