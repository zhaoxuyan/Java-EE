package com.dao;

import com.entity.Student;
import com.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {


    /**
     * 查询全部
     */
    public List<Student> queryAll() throws SQLException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        // 1. 取得连接对象
        Connection connection = DBConnect.getConnect();
        System.out.println(connection);
        // 2.
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list.add(new Student(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)
            ));
        }
        return list;

    }
}
