package com.zhaoxuyan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
            // 获取是否保存用户名和密码
            String daylength = request.getParameter("daylength");
            if (daylength != null && !daylength.equals("-1")) {
                // 保存
                int day = Integer.parseInt(daylength);
                Cookie cname = new Cookie("username", username);
                Cookie cpwd = new Cookie("userpwd", password);
                // 设置保存时间
                cname.setMaxAge(day * 24 * 3600);
                cpwd.setMaxAge(day * 24 * 3600);
                // 添加到response
                response.addCookie(cname);
                response.addCookie(cpwd);

            }
            // 将用户名保存在session中
            HttpSession session = request.getSession();
            session.setAttribute("current_username", username);

            request.setAttribute("username", username);

            // 登录人数+1
            ServletContext sc = this.getServletContext();
            Integer count = (Integer) sc.getAttribute("count");
            if (count != null) {
                count++;
            } else {
                count = 1;
            }
            sc.setAttribute("count", count);

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
