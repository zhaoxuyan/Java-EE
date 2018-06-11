package com.zhaoxuyan.dao;

import com.zhaoxuyan.entity.User;

import com.zhaoxuyan.utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO(Data Access Object)是一个数据访问接口，
 * 数据访问：顾名思义就是与数据库打交道。
 * 夹在业务逻辑与数据库资源中间。
 */
public class UserDao {
    public User findByNameAndPwd(String name, String pwd) throws ClassNotFoundException {
        Connection conn = DBConnect.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from headimg where uname=? and upwd=?");
            ps.setString(1, name);
            ps.setString(2, pwd);
            // 执行
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(rs, ps, conn);
        }
        return null;
    }

    public User getById(int id) throws ClassNotFoundException {
        // 1. 取得连接对象
        Connection conn = DBConnect.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 2.
        try {
            ps = conn.prepareStatement("SELECT * FROM headimg WHERE uid=?");
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(rs, ps, conn);

        }
        return null;
    }

    public int getMaxId() throws ClassNotFoundException {
        // 1. 取得连接对象
        Connection conn = DBConnect.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 2.
        try {
            ps = conn.prepareStatement("SELECT MAX(uid) FROM headimg");
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(rs, ps, conn);
        }
        return 0;
    }

    /**
     * 新增一条数据
     */
    public void addOne(User u) throws ClassNotFoundException {
        Connection conn = DBConnect.getConnect();
        String sql = "insert into headimg values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            //给参数赋值
            ps.setInt(1, this.getMaxId()+1);
            ps.setString(2, u.getUname());
            ps.setString(3, u.getImg_path());
            ps.setString(4, u.getUpwd());
            System.out.println("========================================");
            System.out.println(u.getUpwd());
            // 执行
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBConnect.close(null, ps, conn);
        }
    }
}
