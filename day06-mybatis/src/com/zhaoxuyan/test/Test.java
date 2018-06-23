package com.zhaoxuyan.test;

import com.zhaoxuyan.entity.Student;
import com.zhaoxuyan.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {

        // 1.读取SqlMapConfig.xml配置文件
        String path = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(path);
        // 创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获得会话
        SqlSession session = factory.openSession();
        //mybatis自动生成mapper代理对象
        StudentMapper sm = session.getMapper(StudentMapper.class);
        System.out.println(sm.selectStuById(2));

        Student student = sm.selectStuById(2);
        System.out.println(student.getId() + " "
                + student.getStuname() + " "
                + student.getStuno() + " "
                + student.getStusex() + " "
                + student.getYear() + " ");
    }

}
