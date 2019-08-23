package com.chinasofti.springcloud.service;

import java.util.List;

import com.chinasofti.springcloud.entity.UserMessage;

public interface UserMessageService {

	public List<UserMessage> getList();
	
	public int deleteUserById(String id);
	
	
	
}
