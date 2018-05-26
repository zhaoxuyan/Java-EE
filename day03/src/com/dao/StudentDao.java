package com.dao;

import com.entity.Student;
import com.utils.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO(Data Access Object)是一个数据访问接口，
 * 数据访问：顾名思义就是与数据库打交道。
 * 夹在业务逻辑与数据库资源中间。
 */
public class StudentDao {


    /**
     * 查询全部
     */
    public List<Student> queryAll() throws SQLException, ClassNotFoundException {
        List<Student> list = new ArrayList<>();
        // 1. 取得连接对象
        Connection conn = DBConnect.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 2.
        try {
            ps = conn.prepareStatement("SELECT * FROM student");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(rs, ps, conn);

        }
        return list;

    }

    /**
     * 根据id删除
     */
    public void delById(int id) throws ClassNotFoundException, SQLException {
        // 1. 取得连接对象
        Connection conn = DBConnect.getConnect();
        String sql = "delete from student where id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            //给参数赋值
            ps.setInt(1, id);
            // 执行
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(null, ps, conn);
        }
    }
}
