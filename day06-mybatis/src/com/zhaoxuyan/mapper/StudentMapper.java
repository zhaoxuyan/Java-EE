package com.zhaoxuyan.mapper;

import com.zhaoxuyan.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

//    @Select("select * from student where id=#{id}")
    public Student selectStuById(int id);

//    @Select("select * from student where stuname like '${value}%'")
    public List<Student> selectByFirstName(String firstName);

//    @Insert("insert into student values(#{id},#{stuno},#{stuname},#{stusex},#{year})")
    public void addStudent(Student stu);

//    @Delete("delete from student where id=#{id}")
    public void deleteStudentById(int id);

//    @Update("update student set stuno=#{stuno},stuname=#{stuname},stusex=#{stusex},year=#{year} where id=#{id}")
    public void updateStudentById(Student stu);
}

