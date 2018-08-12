<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ivanmall后台管理页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<c:url value='/css/layui.css'/>">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  
  <!-- 引入头部菜单 -->
  <c:import url='header.jsp'/>
  
  <!-- 引入左侧菜单 -->
  <c:import url='menu.jsp'/>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px; text-align: center; font-size: 22px;margin-top: 10%">欢迎使用Ivanmall后台管理系统</div>
  </div>
  
  <!-- 引入底部说明 -->
  <c:import url='footer.jsp'/>
</div>
</body>
</html>