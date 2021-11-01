package com.xian.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Xian
 * @function JDBC工具类 使用druid连接池
 */
public class DbUtil {
    private static DataSource ds;
    static {
        try {
            //1.加载配置文件
            Properties pr = new Properties();
            //使用ClassLoader加载配置文件，获取字节输入流
            InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pr.load(is);
            //2.初始化连接池
            ds = DruidDataSourceFactory.createDataSource(pr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    //获取连接Connection对象
    public static Connection getCon() throws SQLException {
        return ds.getConnection();
    }

    public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
