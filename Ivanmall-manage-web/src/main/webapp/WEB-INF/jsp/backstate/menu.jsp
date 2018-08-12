<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 左侧菜单 -->
 <div class="layui-side layui-bg-black">
   <div class="layui-side-scroll">
     <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
     <ul class="layui-nav layui-nav-tree"  lay-filter="test">
       <li class="layui-nav-item layui-nav-itemed">
         <a class="" href="javascript:;">商品管理</a>
         <dl class="layui-nav-child">
           <dd><a href="javascript:;">新增商品</a></dd>
           <dd><a href="<c:url value='/item-list'/>">查询商品</a></dd>
           <dd><a href="javascript:;">规格参数</a></dd>
         </dl>
       </li>
       <li class="layui-nav-item layui-nav-itemed">
         <a href="javascript:;">网站内容管理</a>
         <dl class="layui-nav-child">
           <dd><a href="javascript:;">内容分类管理</a></dd>
           <dd><a href="javascript:;">内容管理</a></dd>
         </dl>
       </li>
	<li class="layui-nav-item layui-nav-itemed">
         <a href="javascript:;">用户管理</a>
         <dl class="layui-nav-child">
           <dd><a href="javascript:;">管理员用户管理</a></dd>
           <dd><a href="javascript:;">普通用户管理</a></dd>
         </dl>
       </li>
       <li class="layui-nav-item">
       <a href="javascript:;">其它系统</a>
       <dl class="layui-nav-child">
         <dd><a href="javascript:;">邮件管理</a></dd>
         <dd><a href="javascript:;">消息管理</a></dd>
         <dd><a href="javascript:;">授权管理</a></dd>
       </dl>
     </li>
     </ul>
   </div>
 </div>