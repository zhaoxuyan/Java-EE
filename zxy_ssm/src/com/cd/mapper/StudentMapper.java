package com.cd.mapper;

import java.util.List;

import com.cd.po.Student;

public interface StudentMapper {

	public List<Student> selectAll();

	public List<Student> selectStuById(int id);

	public List<Student> selectByFirstName(String firstName);

	public void addStudent(Student stu);

	public void deleteStudentById(int id);

	public void updateStudentById(Student stu);
}