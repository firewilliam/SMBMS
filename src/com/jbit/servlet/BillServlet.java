package com.jbit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
import com.jbit.entity.Bill;
import com.jbit.entity.Provider;
import com.jbit.entity.Role;
import com.jbit.service.BillService;
import com.jbit.service.ProviderService;

public class BillServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//创建输出对象
		PrintWriter out = response.getWriter();
		//创建json对象
		JSONArray jsonArray=null;
		
		BillService billService=(BillService) ctx.getBean("billService");
		ProviderService providerService= (ProviderService) ctx.getBean("providerService");
		
		
		
		String method=request.getParameter("method");
		if(method.equals("query")){
			Bill bill=null;
			List<Bill> billList=billService.findAllBillList(bill);
			request.setAttribute("billList", billList);
			request.getRequestDispatcher("billlist.jsp").forward(request, response);
			
		}else if(method.equals("view")||method.equals("modify")){
			Bill bill=new Bill();
			Integer billid=Integer.parseInt(request.getParameter("billid"));
			bill.setId(billid);
			bill=billService.findBillById(bill);
			request.setAttribute("bill", bill);
			String url="bill"+method+".jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}else if(method.equals("getproviderlist")){
			
			List<Provider> providerList=providerService.getProviderList();
			jsonArray=new JSONArray();
			jsonArray.addAll(providerList);
			out.print(jsonArray);
			
		}else if(method.equals("modifysave")){
			Bill bill=new Bill();
			bill.setId(Integer.parseInt(request.getParameter("id")));
			bill.setBillCode(request.getParameter("billCode"));
			bill.setProductName(request.getParameter("productName"));
			bill.setProductUnit(request.getParameter("productUnit"));
			bill.setProductCount(new BigDecimal(request.getParameter("productCount")));
			bill.setTotalPrice(new BigDecimal(request.getParameter("totalPrice")));
			bill.setProviderId(Integer.parseInt(request.getParameter("providerId")));
			bill.setIsPayment(Integer.parseInt(request.getParameter("isPayment")));
			int i=billService.updateBillById(bill);
			if(i>0){
				response.sendRedirect("bill.do?method=query");
			}
		}else if(method.equals("delbill")){
			Bill bill=new Bill();
			bill.setId(Integer.parseInt(request.getParameter("billid")));
			
			int i=billService.delBillById(bill);
			String delResult="";
			if(i==1){
				delResult="true";
			}else if(i==0){
				delResult="notexist";
			}else{
				delResult="false";
			}
			delResult="{delResult:'"+delResult+"',}";
			JSONObject data=JSON.parseObject(delResult);
			out.print(data);
		}
		
		
		out.flush();
		out.close();
	}

}
