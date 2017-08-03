package com.jbit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jbit.entity.Role;
import com.jbit.entity.User;
import com.jbit.service.RoleService;
import com.jbit.service.UserService;

public class UserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		PrintWriter out = response.getWriter();
		RoleService roleService=(RoleService) ctx.getBean("roleService");
		UserService userService=(UserService) ctx.getBean("userService");

		//从上一页面取得方法名，以此来选择相应的方法
		String str=request.getParameter("method");
		JSONArray jsonArray=null;
		//拿到角色列表，并保存成session
		List<Role> roleList=roleService.getRoleList();
		request.getSession().setAttribute("roleList", roleList);
		if(str.equals("query")){
			//若取得query方法，即取得UserList
			//带参查询
			User user=new User();
			String userName=request.getParameter("queryname");
			String [] queryUserRole=request.getParameterValues("queryUserRole");
			if(queryUserRole!=null&&!(queryUserRole.equals(""))){
				Integer userRole=Integer.parseInt(queryUserRole[0]);
				if(userRole!=0){
					user.setUserRole(userRole);
				}
			}
			if(userName!=null&&!(userName.equals(""))){
				user.setUserName(userName);
			}
			List<User> userList=userService.getUserList(user);
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("userlist.jsp").forward(request, response);
		}else if(str.equals("getrolelist")){
			//若取得getrolelist方法，即取得getRoleList
			
			jsonArray=new JSONArray();
			jsonArray.addAll(roleList);
			out.print(jsonArray);
		}else if(str.equals("ucexist")){
			String userCode=request.getParameter("userCode");
			User us=null;
			List<User> list=userService.getUserList(us);
			for(User user:list){
				if(user.getUserCode().equals(userCode)){
					userCode="exist";
					break;
				}
			}
			userCode="{userCode:'"+userCode+"',}";
			JSONObject data=JSON.parseObject(userCode);
			out.print(data);
		}else if(str.equals("view")){
			
			Integer uid=Integer.parseInt(request.getParameter("uid"));
			User user=new User();
			user.setId(uid);
			user=userService.getUserById(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("userview.jsp").forward(request, response);
		}else if(str.equals("modify")){
			Integer uid=Integer.parseInt(request.getParameter("uid"));
			User user=new User();
			user.setId(uid);
			user=userService.getUserById(user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("usermodify.jsp").forward(request, response);
		}else if(str.equals("deluser")){
			Integer uid=Integer.parseInt(request.getParameter("uid"));
			User user=new User();
			user.setId(uid);
			int i=userService.delet(user);
			String delResult;
			if(i>0){
				delResult="true";
			}else if(i==0){
				delResult="notexist";
			}else{
				delResult="false";
			}
			String del="{delResult:'"+delResult+"',}";
			JSONObject data=JSON.parseObject(del);
			System.out.println(JSONArray.toJSONString(data));
			out.print(data);
		}else if(str.equals("pwdmodify")){
			String userPassword=request.getParameter("oldpassword");
			User user=(User) request.getSession().getAttribute("userSession");
			String result=null;
			if(userPassword==null&&userPassword.equals("")){
				result="error";
			}else if(user==null){
				result="sessionerror";
			}else if(userPassword.equals(user.getUserPassword())){
				result="true";
			}else{
				result="false";
			}
			result="{result:'"+result+"',}";
			JSONObject data=JSON.parseObject(result);
			System.out.println("--------->"+data.toJSONString());
			out.print(data);
		}else if(str.equals("savepwd")){
			User user=(User) request.getSession().getAttribute("userSession");
			String userPassword=request.getParameter("newpassword");
			int i=userService.updatePwd(user.getId(), userPassword);
			if(i>0){
				response.sendRedirect("user.do?method=query");
			}
		}else if(str.equals("add")){
			//添加用户到数据库
			Date birthday=null;
			try {
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				birthday=format.parse(request.getParameter("birthday"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User user=new User();
			user.setUserCode(request.getParameter("userCode"));
			user.setUserName(request.getParameter("userName"));
			user.setUserPassword(request.getParameter("userPassword"));
			user.setGender(Integer.parseInt(request.getParameter("gender")));
			user.setBirthday(birthday);
			user.setPhone(request.getParameter("phone"));
			user.setAddress(request.getParameter("address"));
			user.setUserRole(Integer.parseInt(request.getParameter("userRole")));
			int i=userService.add(user);
			if(i>0){
				response.sendRedirect("user.do?method=query");
			}
		}else{
			response.sendRedirect("error.jsp");
		}

		out.flush();
		out.close();
		
	}

}
