package com.zrj.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;


public class JDBCUtils {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Driver driver = new Driver();
			Properties info = new Properties();
			InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			info.load(in);
			String url = info.getProperty("url");
			con = driver.connect(url, info);
			System.out.println(con);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		System.out.println(con);
		return con;
	}
	
	public static void closeConnection(Connection con,Statement sta, ResultSet rs) {
		try {
			if(rs!=null)
				rs.close();
			if(sta!=null)
				sta.close();
			if(con!=null)
				con.close();
			System.out.println("连接已关闭!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
