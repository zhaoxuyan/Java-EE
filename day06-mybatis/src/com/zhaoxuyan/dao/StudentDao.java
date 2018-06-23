package com.zhaoxuyan.dao;

import com.zhaoxuyan.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDao {

    public Student queryById(int id) throws IOException {
        Student stu = null;
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();
        // 第一个参数：映射文件中select标签的id（statement的id）
        // 第二个参数：和映射文件中指定的parameterType类型相同的参数
        stu = session.selectOne("selectStuById", id);
        return stu;
    }

    public List<Student> selectByFirstName(String firstName) throws IOException {
        List<Student> list = null;
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();
        list = session.selectList("selectByFirstName", firstName);
        return list;
    }

    public void addStudent(Student stu) throws IOException {
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();

        session.insert("addStudent", stu);
        // 提交事务
        session.commit();
        session.close();
    }

    public void deleteStudentById(int id) throws IOException {
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();
        session.delete("deleteStudentById", id);
        // 提交事务
        session.commit();
        session.close();
    }

    public void updateStudentById(Student stu) throws IOException {
        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();
        session.update("updateStudentById", stu);
        // 提交事务
        session.commit();
        session.close();
    }




}

