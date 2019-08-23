package cn.hd.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.hd.dao.UserDao;
import cn.hd.entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(Integer id) {
		
		User user = getSqlSession().selectOne("findUserById", id);
        return user;
	}
	
	public void saveListUser(List<User> list){
		System.out.println("===插入前===");
		getSqlSession().selectOne("saveListUser", list);
		System.out.println("===插入后===");
	}

}
