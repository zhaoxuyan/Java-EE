package com.zhaoxuyan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Input", urlPatterns = "/Input")
public class Input extends HttpServlet {
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

        // 获取用户信息
        String username = request.getParameter("username");
        String id = request.getParameter("id");
        String gender = request.getParameter("gender");
        String country = request.getParameter("list");


        System.out.println("姓名：" + username);
        System.out.println("身份证号：" + id);
        System.out.println("性别：" + gender);
        System.out.println("国籍:" + country);

        out.println(username + "<br>");
        out.println(id + "<br>");
        out.println(gender + "<br>");
        out.println(country + "<br>");

        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
