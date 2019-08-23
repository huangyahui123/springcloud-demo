package cn.hd.mapper;

import java.util.List;

import cn.hd.entity.User;

public interface UserMapper {
	
	User findUserById(Integer id);
	
	void saveListUser(List<User> list);
	
}
