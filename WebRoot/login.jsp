<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
  </head>
  
 <body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>超市订单管理系统</h1>
        </header>
        <section class="loginCont">
        <form:form modelAttribute="user" action="${pageContext.request.contextPath }/login.do" cssClass="loginForm" method="post" name="actionForm" id="actionForm" >
	        <div class="info">${error }</div>
				<div class="inputbox">
                    <form:label path="userCode" for="user">用户名：</form:label>
                    <input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required/>
                   
					</div>	
				<div class="inputbox">
                    <label for="mima">密码：</label>
                     <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
                </div>	
				<div class="subBtn">
					
                    <input type="submit" value="登录"/>
                    <input type="reset" value="重置"/>
                </div>	
			</form:form>
        </section>
    </section>
</body>
</html>
