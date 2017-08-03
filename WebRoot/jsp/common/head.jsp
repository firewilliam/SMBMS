<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
  </head>
  
  <body>
   <!--头部-->
    <header class="publicHeader">
        <h1>超市订单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${userSession.userName }</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/jsp/logout.do">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
              <li ><a href="${pageContext.request.contextPath }/bill.do?method=query">订单管理</a></li>
              <li><a href="${pageContext.request.contextPath }/provider.do?method=query">供应商管理</a></li>
              <li><a href="${pageContext.request.contextPath }/user.do?method=query">用户管理</a></li>
              <li><a href="${pageContext.request.contextPath }/pwdmodify.jsp">密码修改</a></li>
              <li><a href="${pageContext.request.contextPath }/logout.do">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
  </body>
</html>
