package com.jbit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbit.dao.RoleMapper;
import com.jbit.entity.Role;
import com.jbit.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper; 
	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return roleMapper.getRoleList();
	}
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
	

}
