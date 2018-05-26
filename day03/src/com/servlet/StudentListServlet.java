package com.servlet;

import com.dao.StudentDao;
import com.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentListServlet", urlPatterns = "/StudentListServlet")
public class StudentListServlet extends HttpServlet {
    private StudentDao dao = new StudentDao();
    /**
     * Constructor of the object.
     */
    public StudentListServlet()

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
//        List<Student> list = new ArrayList<>();
//        list.add(new Student(1,"stu001","赵绪言","男",21));
//        list.add(new Student(2,"stu002","张三","女",22));
//        list.add(new Student(3,"stu003","李四","男",31));
//        list.add(new Student(4,"stu004","王麻子","女",12));
//        list.add(new Student(5,"stu005","赵二狗","男",24));
        List<Student> list = null;
        try {
            list = dao.queryAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("students", list);
        request.getRequestDispatcher("student_show.jsp").forward(request,response);

    }
}
