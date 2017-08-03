package com.jbit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jbit.entity.User;
import com.jbit.service.UserService;
import com.jbit.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userCode=request.getParameter("userCode");
		String userPassword=request.getParameter("userPassword");
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) ctx.getBean("userService");
		
		User user=new User();
		user.setUserCode(userCode);
		user.setUserPassword(userPassword);
		User uss=userService.login(user);
		if(uss!=null){
			request.getSession().setAttribute("userSession", uss);
			request.getRequestDispatcher("jsp/frame.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.jsp");
		}
		
	}

}
