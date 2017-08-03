package com.jbit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jbit.dao.impl.UserDaoImpl;
import com.jbit.entity.User;

public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		UserDaoImpl dao=new UserDaoImpl();
		User user=new User();
		user.setId(1);
		//user.setUserCode("testmodify");
		//user.setUserName("测试");
		//user.setUserPassword("0000000");
		//Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1980-10-10");
		//user.setBirthday(birthday);
		//user.setCreationDate(new Date());
		//user.setAddress("地址测");
		//user.setGender(2);
		//user.setPhone("13600002222");
		//user.setUserRole(2);
		//user.setModifyBy(1);
		//user.setModifyDate(new Date());
		//
		/*int i=dao.add(user);
		if(i>0){
			System.out.println("!!!");
		}*/
		//dao.modify(user);
		/*String pwd="87654321";
		int id=1;
		int i=dao.updatePwd(id, pwd);
		if(i>0){
			System.out.println("!!!");
		}*/
		/*List<User> list=dao.getUserListByRoleId(3);
		for(User u:list){
			System.out.println(u.getUserName()+"_____"+u.getRole().getRoleName()+"____"+u.getRole().getCreationDate());
		}*/
		User users=dao.getUserById(user);
		System.out.println(users.getUserName());
		
		
		
	}

}
