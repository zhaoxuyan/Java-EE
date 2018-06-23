package com.zhaoxuyan.controller;

import com.zhaoxuyan.entity.Student;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class StudentRequestController implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "1", "s", "100",22));
        list.add(new Student(2, "2", "2", "200",22));
        request.setAttribute("list", list);
        //指定要跳转的jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

