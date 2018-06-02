package com.servlet;

import com.dao.StudentDao;
import com.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentUpdateServlet", urlPatterns = "/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
    private StudentDao dao = new StudentDao();

    /**
     * Constructor of the object.
     */
    public StudentUpdateServlet()

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
        String idstr = request.getParameter("id");
        int id = Integer.parseInt(idstr);
        //将数据放入request中，传递到页面
        Student student = StudentDao.queryById(id);
        request.setAttribute("students", student);
        request.getRequestDispatcher("student_alter.jsp").forward(request, response);
    }
}
