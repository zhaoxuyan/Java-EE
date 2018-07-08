package com.cd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cd.mapper.StudentMapper;
import com.cd.po.Student;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper mapper;

	@Override
	public List<Student> getAll() {
		return mapper.selectAll();
	}

	@Override
	public void addStudent(Student stu){
		 mapper.addStudent(stu);
	}
	@Override
	public void delStudent(int id){
		 mapper.deleteStudentById(id);
	}
	@Override
	public void updStudent(Student stu){
		 mapper.updateStudentById(stu);
	}

	@Override
	public List<Student> selectStuById(int id) {
		return mapper.selectStuById(id);
	}

	@Override
	public List<Student> selectByFirstName(String firstName){
		return mapper.selectByFirstName(firstName);
	}
}
