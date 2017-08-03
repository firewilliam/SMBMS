<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/jsp/common/head.jsp"></jsp:include>
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
  </head>
  
  <body>
    <div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>订单管理页面 >> 信息查看</span>
     </div>
     <div class="providerView">
         <p><strong>订单编号：</strong><span>${bill.billCode }</span></p>
         <p><strong>商品名称：</strong><span>${bill.productName }</span></p>
         <p><strong>商品单位：</strong><span>${bill.productUnit }</span></p>
         <p><strong>商品数量：</strong><span>${bill.productCount }</span></p>
         <p><strong>总金额：</strong><span>${bill.totalPrice }</span></p>
         <p><strong>供应商：</strong><span>${bill.provider.proName }</span></p>
         <p><strong>是否付款：</strong>
         	<span>
         		<c:if test="${bill.isPayment == 1}">未付款</c:if>
				<c:if test="${bill.isPayment == 2}">已付款</c:if>
			</span>
		</p>
		<div class="providerAddBtn">
         	<input type="button" id="back" name="back" value="返回" >
        </div>
     </div>
 </div>
</section>
<jsp:include page="/jsp/common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billview.js"></script>
  </body>
</html>
