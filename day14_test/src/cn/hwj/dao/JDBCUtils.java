package cn.hwj.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String sDriver;
    private static String sUrl;
    private static String sUserName;
    private static String sPassWord;
    private static Connection sConn=null;
    private static ResultSet sResultSet;
    private static PreparedStatement sPreparedStatement;

    public static Connection getConnection(){
        Properties pro = new Properties();
        InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            pro.load(in);
            sDriver = pro.getProperty("driver");
            sUrl=pro.getProperty("url");
             sUserName =pro.getProperty("username");
            sPassWord = pro.getProperty("password");
            //加载驱动
            Class.forName(sDriver);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            sConn= DriverManager.getConnection(sUrl,sUserName,sPassWord);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sConn;
    }
}
