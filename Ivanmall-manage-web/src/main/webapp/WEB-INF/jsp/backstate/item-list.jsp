<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ivanmall商品列表分页</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<c:url value='/css/layui.css'/>" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  
  <!-- 引入头部菜单 -->
  <c:import url='header.jsp'/>
  
  <!-- 引入左侧菜单 -->
  <c:import url='menu.jsp'/>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <!-- 分页表格 -->
 	<table id="itemTable" lay-filter="itemFilter"></table>
 	<!-- <div id="itemTable" lay-filter="itemFilter" ></div> -->

  <!-- 引入底部说明 -->
  <c:import url='footer.jsp'/>
</div>
</body>
<script src="<c:url value='/js/layui.js'/>"></script>
<script type="text/html" id="barOp">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  //table实例
  table.render({
    elem: '#itemTable'
    ,height: 480
    ,width: 1000
    ,url: '/item/list' //数据接口
    ,limits: [10, 15, 20]
    ,page: true //开启分页
    ,cols: [[
        {type:'checkbox'}
        ,{field:'id', width:80, title: 'ID', sort: true}
        ,{field:'name', width:120, title: '商品名称'}
        ,{field:'price', width:120, title: '商品价格', sort: true}
        ,{field:'description', width:250, title: '商品描述'}
        ,{fixed: 'right', width:200, align:'center', toolbar: '#barOp'} //这里的toolbar值是模板元素的选择器
      ]]
  });
	//监听表格复选框选择
  table.on('checkbox(itemFilter)', function(obj){
    console.log(obj)
  });
  //监听工具条
  table.on('tool(itemFilter)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      layer.msg('ID：'+ data.id + ' 的查看操作');
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data))
    }
  });
  
});
</script>
</html>