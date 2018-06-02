package com.servlet;

import com.entity.Student;
import com.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentAddServlet", urlPatterns = "/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
    private StudentDao dao = new StudentDao();

    /**
     * Constructor of the object.
     */
    public StudentAddServlet()

    {
        super();
    }

    public void init() throws ServletException {
        // Put your code here
    }

    /**
     * Destruction of the StudentAddServlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取参数
        String idstr = request.getParameter("id");
        int id = Integer.parseInt(idstr);
        String stuno = request.getParameter("stuno");
        String stuname = request.getParameter("name");
        String stusex = request.getParameter("gender");
        String agestr = request.getParameter("age");
        int year = Integer.parseInt(agestr);
        //调用dao方法修改
        try {
            dao.addstudent(id, stuno, stuname, stusex, year);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Student> list = null;
        try {
            list = dao.queryAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("students", list);
        //跳转回列表页面
        request.getRequestDispatcher("student_show.jsp").forward(request, response);
    }
}
