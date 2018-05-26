package com.utils;
import java.sql.*;

public class DBConnect {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/JavaWeb?useSSL=false";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "newpass";

    static {
        //STEP 2: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        Connection conn = getConnect();
        System.out.println(conn);
        Statement stmt = conn.createStatement();
        System.out.println(stmt);
    }

    public static Connection getConnect() throws ClassNotFoundException {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("database connect failed...");
        }
        return conn;
    }

    /**
     * 关闭连接
     */
    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接
     */
    public static void close(ResultSet rs, CallableStatement cs, Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(cs != null) {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    private static void query(Statement stmt, String tableName) throws SQLException {
//        System.out.println("执行查询操作===>");
//        String selectSql = "select *from " + tableName;
//        ResultSet rs = stmt.executeQuery(selectSql);
//        while (rs.next()) {
//            //Retrieve by column name
//            String ProductNo1 = rs.getString("ProductNo");
//            String ProductName1 = rs.getString("ProductName");
//            String SinglePrice1 = rs.getString("SinglePrice");
//            String StoreNumber1 = rs.getString("StoreNumber");
//
//            //Display values
//            System.out.print("ID: " + ProductNo1);
//            System.out.print(", ProductName: " + ProductName1);
//            System.out.print(", SinglePrice: " + SinglePrice1);
//            System.out.println(", StoreNumber: " + StoreNumber1);
//        }
//        rs.close();
//    }
}