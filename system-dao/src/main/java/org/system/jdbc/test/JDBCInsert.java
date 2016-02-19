package org.system.jdbc.test;


import java.sql.*;

/**
 * Created by wangyanming on 2015/11/18.
 */
public class JDBCInsert
{
    private static int insert() {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into user (id,name,age) values(?,?,?)";
        CallableStatement pstmt;
        try {
            pstmt = conn.prepareCall(sql);
            pstmt.setString(1, "100");
            pstmt.setString(2, "mike");
            pstmt.setString(3, "20");
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                throw new RuntimeException("test");
                //conn.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return i;
    }
    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/system";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String [] args)
    {
        insert();
    }
}
