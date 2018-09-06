<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value='/css/layui.css'/>">

<!-- 左侧菜单 -->
 <div class="layui-side layui-bg-black">
   <div class="layui-side-scroll">
     <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
     <ul class="layui-nav layui-nav-tree">
       <li class="layui-nav-item layui-nav-itemed">
         <a class="" href="javascript:;">商品管理</a>
         <dl class="layui-nav-child">
           <dd><a href="<c:url value='/item-add'/>">新增商品</a></dd>
           <dd><a href="<c:url value='/item-list'/>">查询商品</a></dd>
         </dl>
       </li>
       <li class="layui-nav-item layui-nav-itemed">
         <a href="javascript:;">商品分类管理</a>
         <dl class="layui-nav-child">
           <dd><a href="<c:url value='/category-add'/>">新增商品分类</a></dd>
           <dd><a href="<c:url value='/category-list'/>">查询商品分类</a></dd>
         </dl>
       </li>
	   <li class="layui-nav-item layui-nav-itemed">
         <a href="javascript:;">用户管理</a>
         <dl class="layui-nav-child">
           <dd><a href="<c:url value='/msgManage'/>">管理员用户管理</a></dd>
           <dd><a href="<c:url value='/msgManage'/>">普通用户管理</a></dd>
         </dl>
       </li>
       <li class="layui-nav-item layui-nav-itemed">
       <a href="javascript:;">其它管理</a>
       <dl class="layui-nav-child">
         <dd><a href="https://mail.qq.com" target="_blank">QQ邮箱登录</a></dd>
         <dd><a href="https://mail.163.com" target="_blank">网易邮箱登录</a></dd>
         <dd><a href="/msgManage">消息管理</a></dd>
       </dl>
     </li>
     </ul>
   </div>
 </div>
<script src="<c:url value='/js/layui.js'/>"></script>
<script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
});

/* layui.use(['jquery'], function(){
  var $ = jQuery = layui.$;
 
}); */
</script>