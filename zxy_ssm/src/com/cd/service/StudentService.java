package com.cd.service;

import java.util.List;

import com.cd.po.Student;

public interface StudentService {

	public List<Student> getAll();

	public void addStudent(Student stu);
	
	public void delStudent(int id);
	
	public void updStudent(Student stu);
	
	public List<Student> selectStuById(int id);
	
	public List<Student> selectByFirstName(String firstName);
}
