package com.utils;
import java.sql.*;

public class DBConnect {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/Sales?useSSL=false";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "newpass";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            query(stmt,"Product");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("database connect failed...");
        }
    }

    private static void query(Statement stmt, String tableName) throws SQLException {
        System.out.println("执行查询操作===>");
        String selectSql = "select *from " + tableName;
        ResultSet rs = stmt.executeQuery(selectSql);
        while (rs.next()) {
            //Retrieve by column name
            String ProductNo1 = rs.getString("ProductNo");
            String ProductName1 = rs.getString("ProductName");
            String SinglePrice1 = rs.getString("SinglePrice");
            String StoreNumber1 = rs.getString("StoreNumber");

            //Display values
            System.out.print("ID: " + ProductNo1);
            System.out.print(", ProductName: " + ProductName1);
            System.out.print(", SinglePrice: " + SinglePrice1);
            System.out.println(", StoreNumber: " + StoreNumber1);
        }
        rs.close();
    }
}