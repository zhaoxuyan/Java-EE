package com.zhaoxuyan.servlet;

import com.zhaoxuyan.dao.UserDao;
import com.zhaoxuyan.entity.User;
import com.zhaoxuyan.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
@MultipartConfig
//(location = "/headimgs") 这里不能设置location，否则拿不到其他表单参数
public class RegisterServlet extends HttpServlet {
    /**
     * Constructor of the object.
     */
    public RegisterServlet()

    {
        super();
    }

    public void init() throws ServletException {
        // Put your code here
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户名和密码
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        // 获取头像
        Part headimg = request.getPart("headimg");
        String contentDisposition = headimg.getHeader("content-disposition");
        System.out.println("content-disposition=" + contentDisposition);
        String filename = null;
        Pattern pattern = Pattern.compile("filename=\".+\"");
        Matcher matcher = pattern.matcher(contentDisposition);
        if (matcher.find()) {
            System.out.println();
            filename = matcher.group();
            System.out.println("filename=" + filename);
            filename = filename.substring(10, filename.length() - 1);
            System.out.println("subfilename=" + filename);
        }
        if (filename != null) {
            // 给文件名加前缀
            filename = UUID.randomUUID().toString() + filename;
            String basePath = this.getServletContext().getRealPath("/");
            String path = basePath + "/headimg/" + filename;
            headimg.write(path);
        }
        //将信息存入数据库
        UserService service = new UserService();
        try {
            service.register(new User(uname,filename,upwd));
            System.out.println("this is RegisterServlet============");
            System.out.println(uname);
            System.out.println(filename);
            System.out.println(upwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //跳转登录页面
        request.setAttribute("error_message", "注册成功！");
        request.getRequestDispatcher("/login.jsp").forward(request, response);


    }
}
