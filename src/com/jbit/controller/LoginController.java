package com.jbit.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jbit.entity.User;
import com.jbit.service.UserService;

@Controller
@SessionAttributes("userSession")//设置了一个session(或者用转发model的方式)
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	private String login(User user){
		
	
		return "../login";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	private String login(User user,Model model){
		
		User uss=userService.login(user);
		
		if(uss!=null){
			
			model.addAttribute("userSession", uss);
			return "frame";
		}else{
			model.addAttribute("error", "登陆失败，请重新登陆");
			return "../login";
		}
		
	}
}
