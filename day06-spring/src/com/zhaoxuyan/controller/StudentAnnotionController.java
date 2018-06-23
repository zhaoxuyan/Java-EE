package com.zhaoxuyan.controller;

import com.zhaoxuyan.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class StudentAnnotionController {

    @RequestMapping("/stus")
    public ModelAndView queryStuList(){
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "1", "s", "100",22));
        list.add(new Student(2, "2", "2", "200",22));
        //创建ModelAndView
        System.out.println();
        ModelAndView mv = new ModelAndView();
        //相当于rquest.setAttribute()
        mv.addObject("list", list);
        //指定要跳转的jsp
        mv.setViewName("/index.jsp");
        return mv;
    }
}

