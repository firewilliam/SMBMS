package com.jbit.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jbit.entity.User;
import com.jbit.service.UserService;

@Controller(value="/jsp")
public class UserController {
	private Logger logger=Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/user.do",method=RequestMethod.GET)
	private String list(String method,Model model){
		if(method.equals("query")){
			
			User user=new User();
			/*String userName=request.getParameter("queryname");
			String [] queryUserRole=request.getParameterValues("queryUserRole");
			if(queryUserRole!=null&&!(queryUserRole.equals(""))){
				Integer userRole=Integer.parseInt(queryUserRole[0]);
				if(userRole!=0){
					user.setUserRole(userRole);
				}
			}
			if(userName!=null&&!(userName.equals(""))){
				user.setUserName(userName);
			}*/
			List<User> userList=userService.getUserList(user);
			model.addAttribute("userList", userList);
			return "userlist";
			
			
		}else if(method.equals("view")){
			
			
		}else{
			
		}
		
		
		return null;
	}
	
	
}
