package com.servlet;

import com.dao.StudentDao;
import com.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutput;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentDelServlet", urlPatterns = "/StudentDelServlet")
public class StudentDelServlet extends HttpServlet {
    private StudentDao dao = new StudentDao();

    /**
     * Constructor of the object.
     */
    public StudentDelServlet()

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
        try {
            // 获取参数id 执行删除操作
            String idstr = request.getParameter("id");
            int id = Integer.parseInt(idstr);
            dao.delById(id);
            // 刷新页面 并 跳转回列表页面
            List<Student> list = dao.queryAll();
            request.setAttribute("students", list);
            request.getRequestDispatcher("student_show.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
