<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
            <span>供应商管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>供应商编码：</strong><span>${provider.proCode }</span></p>
            <p><strong>供应商名称：</strong><span>${provider.proName }</span></p>
            <p><strong>联系人：</strong><span>${provider.proContact }</span></p>
            <p><strong>联系电话：</strong><span>${provider.proPhone }</span></p>
            <p><strong>传真：</strong><span>${provider.proFax }</span></p>
            <p><strong>描述：</strong><span>${provider.proDesc}</span></p>
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<jsp:include page="/jsp/common/foot.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/providerview.js"></script>
  </body>
</html>
