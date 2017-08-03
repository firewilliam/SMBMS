package com.jbit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jbit.entity.User;

public interface UserService {
	public User login(User user);
	public List<User> getUserList(User user);
	public User getUserById(User user);
	public int delet(User user);
	
	
    public void modify(User user);
    public int add(User user);
    public int updatePwd(@Param("id")Integer id, @Param("userPassword")String pwd);
    public List<User> getUserListByRoleId(int roleId);
    
}
