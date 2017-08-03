package com.jbit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbit.dao.UserMapper;
import com.jbit.entity.User;
import com.jbit.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return userMapper.add(user);
	}

	@Override
	public List<User> getUserListByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return userMapper.getUserListByRoleId(roleId);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	@Override
	public void modify(User user) {
		// TODO Auto-generated method stub
		userMapper.modify(user);
	}

	@Override
	public int updatePwd(Integer id, String pwd) {
		// TODO Auto-generated method stub
		return userMapper.updatePwd(id, pwd);
	}

	@Override
	public List<User> getUserList(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserList(user);
	}

	@Override
	public User getUserById(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(user);
	}

	@Override
	public int delet(User user) {
		// TODO Auto-generated method stub
		return userMapper.delet(user);
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	
	
	
}
