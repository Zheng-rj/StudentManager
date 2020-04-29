package com.zrj.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Driver;
import com.zrj.Entity.Student;

public class MyUtils {
	static DataSource ds = null;
	static Connection con = null;
//	static{
//		try {
//			Properties pro = new Properties();
//			InputStream in = Test.class.getClassLoader().getResourceAsStream("dbsp.properties");
//			pro.load(in);
//			ds = BasicDataSourceFactory.createDataSource(pro);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	static QueryRunner qr = new QueryRunner();
	public static void main(String[] args) {
//		mySelectMain("select * from user where id=?",2);  				//查询单条数据
//		mySelectMain("select * from user");								//查询多条数据			
//		mySelectMain("select count(id) from user");						//查询单个信息
		mySelectOne("select * from user where id=?", Student.class, 3);
//		mySelect("select * from user where id=?", User.class, 2);		//查询单条数据	
//		mySelect("select * from user", User.class);                     //查询多条数据
//		myQuery("insert into user(name,password) values(?,?)","Zhang","zrxzrx");
//		myQuery("delete from user where id = ?",1);
//		myQuery("update user set name=? where id=?","Zhang",4);
	}
	
	//查询数据(用键值对的形式显示数据,单条数据	、多条数据、单个信息都可以查询,显示字段名)
	public static List<Map<String, Object>> mySelectMain(String sql,Object ...obj) {
		Connection con = getC3P0Connect();
		List<Map<String, Object>> list = null;
		try {
			list = qr.query(con, sql, new MapListHandler(), obj);
			for(Map<String, Object> map :list){
				for(Map.Entry<String, Object> m :map.entrySet()){
					System.out.println(m.getKey()+"==>"+m.getValue());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return list;
	}
	
	//查询单条数据(直接保存在对象中,只可查询单条数据)
	public static <T> T mySelectOne(String sql,Class<T> t ,Object ...value) {
		Connection con = getC3P0Connect();
		T o = null;
		try {
			o = (T) qr.query(con, sql, new BeanHandler<T>(t), value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	//查询多条数据(将多个对象保存在list中,可查询单条数据或多条数据)
	public static <T> List<T> mySelect(String sql, Class<T> t, Object ...obj) {
		Connection con = getC3P0Connect();
		List<T> list = new ArrayList<T>(); 
		try {
			list = qr.query(con, sql, new BeanListHandler<>(t), obj);
			for(T x:list) {
//				System.out.println(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//执行增删改语句
	public static int myQuery(String sql,Object ...obj) {
		Connection con = getC3P0Connect();
		int row = 0;
		try {
			row = qr.update(con, sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	@Test
	//创建jdbc连接
	public static Connection getConnection(){
			Connection con = null;		
			try {
				System.out.println("----"); 
				Driver driver = new Driver();
				Properties info = new Properties();
				InputStream in = MyUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
				info.load(in);
				String url = info.getProperty("url");
				con = driver.connect(url, info);
				System.out.println(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
	
	//创建dbcp连接
	public static Connection getDBCPConnect() {
		Connection con = null;
		try {
			con = ds.getConnection();
			System.out.println(con.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//创建c3p0连接
	public static Connection getC3P0Connect() {
		System.out.println("c3p0Connect");
		ComboPooledDataSource cpds = new ComboPooledDataSource("myc3p0");
		Connection con = null;
		try {
			con = cpds.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return con;
	}
	
	//关闭连接
	public static void closeAll(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(con!=null)
				con.close();
			System.out.println("连接已关闭!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
