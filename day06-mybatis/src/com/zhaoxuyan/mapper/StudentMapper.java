package com.zhaoxuyan.mapper;

import com.zhaoxuyan.entity.Student;

import java.util.List;

public interface StudentMapper {

    public Student selectStuById(int id);

    public List<Student> selectByFirstName(String firstName);

    public void addStudent(Student stu);

    public void deleteStudentById(int id);

    public void updateStudentById(Student stu);
}

