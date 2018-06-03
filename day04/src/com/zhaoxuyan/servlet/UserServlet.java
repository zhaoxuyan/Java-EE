package com.zhaoxuyan.servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

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

            // 请求时带一个参数:username，在success.jsp中通过${username}使用
            request.setAttribute("username", username);

            // 登录人数+1（通过ServletContext上下文实现）
            ServletContext sc = this.getServletContext();
            Integer count = (Integer) sc.getAttribute("count");
            if (count != null) {
                count++;
            } else {
                count = 1;
            }
            sc.setAttribute("count", count);
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("fail.jsp").forward(request, response);
        }


    }

}

