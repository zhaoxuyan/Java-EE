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

    /**
     * 增加
     */
    public void addstudent(int id, String stuno, String stuname, String stusex, int year) throws ClassNotFoundException {
        Connection conn = DBConnect.getConnect();
        String sql = "insert into student values (?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            //给参数赋值
            ps.setInt(1, id);
            ps.setString(2, stuno);
            ps.setString(3, stuname);
            ps.setString(4, stusex);
            ps.setInt(5, year);
            // 执行
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(null, ps, conn);
        }
    }

    /**
     * 根据id修改
     */
    public static void alterById(int id, String stuno, String stuname, String stusex, int year) throws ClassNotFoundException {
        Connection conn = DBConnect.getConnect();
        String sql = "update student set stuno=?,stuname=?,stusex=?,year=? where id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            //给参数赋值
            ps.setString(1, stuno);
            ps.setString(2, stuname);
            ps.setString(3, stusex);
            ps.setInt(4, year);
            ps.setInt(5, id);
            // 执行
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(null, ps, conn);
        }
    }

    /**
     * 根据id查询
     * @param id
     */
    public static Student queryById(int id){
        String sql = "select * from student where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        Student student = null;
        try {
            conn = DBConnect.getConnect();
            ps =conn.prepareStatement(sql);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while(res.next()){
                student = new Student(res.getInt(1),res.getString(2), res.getString(3), res.getString(4), res.getInt(5));
            }

        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try{
                if(null!=res){
                    res.close();
                }
                if(null!=ps){
                    ps.close();
                }
                if(null!=conn){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return student;
    }
}
