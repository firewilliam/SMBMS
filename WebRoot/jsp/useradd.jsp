<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/jsp/common/head.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加用户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  <body>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/jsp/user.do">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userCode">用户编码：</label>
                    <input type="text" name="userCode" id="userCode" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="userPassword" id="userPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" name="ruserPassword" id="ruserPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label >用户性别：</label>
					<select name="gender" id="gender">
					    <option value="1" selected="selected">男</option>
					    <option value="2">女</option>
					 </select>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                   <input name="address" id="address"  value="">
                </div>
                <div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<select name="userRole" id="userRole"></select>
	        		<font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<jsp:include page="/jsp/common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/useradd.js"></script>
  </body>
</html>
