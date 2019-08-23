package com.chinasofti.springcloud.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chinasofti.springcloud.entity.UserMessage;
import com.chinasofti.springcloud.service.UserMessageService;
import com.chinasofti.springcloud.util.DBUtils;


@Service
public class UserMessageServiceImpl implements UserMessageService{

	@Override
	public List<UserMessage> getList() {
		
		List<UserMessage> list = new ArrayList<>();
		try {
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from t_user";
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()){
				UserMessage userMessage = new UserMessage();
				userMessage.setId(result.getString("id"));
				userMessage.setUsername(result.getString("username"));
				userMessage.setAge(result.getString("age"));
				userMessage.setSex(result.getString("sex"));
				userMessage.setRemark(result.getString("remark"));
				list.add(userMessage);
			}
			
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteUserById(String id) {
		try {
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from t_user where id = " +id;
			int count = stmt.executeUpdate(sql);
			return count;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
