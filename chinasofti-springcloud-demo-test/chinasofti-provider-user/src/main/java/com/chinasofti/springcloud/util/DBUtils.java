package com.chinasofti.springcloud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DBUtils {
	
	public static void main(String[] args) {
		
		new DBUtils().execute();;
		
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	@Transactional
	public void execute(){
		new DBUtils().saveUser();
		new DBUtils().deleteUser();
	}
	
	@Transactional
	public int saveUser(){
		Connection conn = getConnection();
		//插入数据
		String insertSql = "insert into t_user values ('500','ee','30','f','other message')";
		int count = 0;
		try {
			
			//异常
			String string = null;
			System.out.println(string.toString());
			
			
			Statement stmt = conn.createStatement();
			count = stmt.executeUpdate(insertSql);
			
			
			
			conn.close();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException("保存失败");
		}
		if (count == 1) {
			System.out.println("插入成功!!!");
		}else{
			System.out.println("插入失败!!!");
		}
		return count;
	}
	
	
	@Transactional
	public int deleteUser(){
		Connection conn = getConnection();
		//删除数据
		String deleteSql = "delete from t_user where id = '300' ";
		int countDelete = 0;
		try {
			Statement stmt = conn.createStatement();
			countDelete = stmt.executeUpdate(deleteSql);
			conn.close();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException("删除失败");
		}
		if(countDelete == 1){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		return countDelete;
	}
	
	public void queryUser(){
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			//查询数据
			String querySql = "select * from t_user";
			ResultSet result = stmt.executeQuery(querySql);
			while(result.next()){
				System.out.println(result.getString("id") + "  " + result.getString("username") + "  " +result.getString("age") + "  " + result.getString("sex") + "  " + result.getString("remark"));
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
