package com.cd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cd.po.Student;
import com.cd.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/listStudent")
	public ModelAndView listStudent(){
		List<Student> list = this.studentService.getAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("/index.jsp");
		return mv;
	}

	@RequestMapping("/studentAdd")
	public ModelAndView studentAdd(Student stu){
		this.studentService.addStudent(stu);
		return this.listStudent();
	}

	@RequestMapping("/selectById")
	public ModelAndView selectStuById(int id){
		List<Student> stu=this.studentService.selectStuById(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("stu", stu);
		mv.setViewName("/upd.jsp");
		return mv;
	}

	@RequestMapping("/selectById2")
	public ModelAndView selectStuById2(int id){
		List<Student> stu=this.studentService.selectStuById(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("stu", stu);
		mv.setViewName("/show.jsp");
		return mv;
	}

	@RequestMapping("/studentDel")
	public ModelAndView studentDel(int id){
		this.studentService.delStudent(id);
		return this.listStudent();
	}

	@RequestMapping("/studentUpd")
	public ModelAndView studentUpd(Student stu){
		this.studentService.updStudent(stu);
		return this.listStudent();
	}

	@RequestMapping("/listByName")
	public ModelAndView listByName(@RequestParam("name")String firstName){
		List<Student> stu = this.studentService.selectByFirstName(firstName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("stu", stu);
		mv.setViewName("/show.jsp");
		return mv;
	}
}

