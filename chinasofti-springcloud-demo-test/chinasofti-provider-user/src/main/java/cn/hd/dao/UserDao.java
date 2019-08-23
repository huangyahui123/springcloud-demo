package cn.hd.dao;

import java.util.List;

import cn.hd.entity.User;

public interface UserDao {
    /*没有写事务只能写查询，增删改要提交事务才有用*/
    User findUserById(Integer id);
    
    void saveListUser(List<User> list);
}
