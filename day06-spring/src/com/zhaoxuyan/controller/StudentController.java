package com.zhaoxuyan.controller;

import com.zhaoxuyan.entity.Student;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class StudentController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest arg0,
                                      HttpServletResponse arg1) throws Exception {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "1", "s", "100",22));
        list.add(new Student(2, "2", "2", "200",22));
        //创建ModelAndView
        ModelAndView mv = new ModelAndView();
        //相当于rquest.setAttribute()
        mv.addObject("list", list);
        //指定要跳转的jsp
        mv.setViewName("/index.jsp");
        return mv;
    }
}

