<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 头部菜单 -->
<div class="layui-header">
  <div class="layui-logo" style="cursor:pointer"><a class="layui-logo" href="<c:url value='/'/>">Ivanmall商城后台管理</a></div>
  <!-- 头部区域（可配合layui已有的水平导航） -->
  <ul class="layui-nav layui-layout-right">
    <li class="layui-nav-item">
      <a href="javascript:;">
        <img src="<c:url value='/images/Ivan.jpg'/>" class="layui-nav-img">Ivan
      </a>
      <dl class="layui-nav-child">
        <dd><a href="">基本资料</a></dd>
        <dd><a href="">安全设置</a></dd>
      </dl>
    </li>
    <li class="layui-nav-item"><a href="">退出</a></li>
  </ul>
</div>
