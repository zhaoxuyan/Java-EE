package com.zhaoxuyan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    /**
     * Constructor of the object.
     */
    public UserServlet() {
        super();
        System.out.println("调用了构造方法");
    }

    public void init() throws ServletException {
        // Put your code here
        System.out.println("调用了init()方法");
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
        System.out.println("调用了destroy()方法");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理响应的中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE>");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");

        // add something
        // 获取输入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("userpwd");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);

        // 用户名密码验证
        if (username.equals("123") && password.equals("123")) {
            // 跳转到成功页面
            // 响应重定向
//            response.sendRedirect("success.jsp");
            // 请求转发
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            // 跳转到失败页面
            // 响应重定向
//            response.sendRedirect("fail.jsp");
            // 请求转发
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }


        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
