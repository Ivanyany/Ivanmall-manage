<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分类添加</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<!-- 引入头部菜单 -->
		<c:import url='header.jsp' />

		<!-- 引入左侧菜单 -->
		<c:import url='menu.jsp' />

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<form class="layui-form layui-form-pane" action="/addCategory" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">分类名称</label>
					<div class="layui-input-block">
						<input type="text" name="name" lay-verify="required"
							placeholder="输入商品分类名称" autocomplete="off" class="layui-input">
					</div>
				</div>
				 <!-- <div class="layui-form-item">
				    <div class="layui-inline">
				      <label class="layui-form-label">创建时间</label>
				      <div class="layui-input-block">
				        <input type="text" name="createTime" id="createTime" autocomplete="off" class="layui-input">
				      </div>
				    </div>
				 </div> -->
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="categoryForm">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>

		<!-- 引入底部说明 -->
		<c:import url='footer.jsp' />
	</div>
</body>
<script>
layui.use(['form', 'laydate'], function(){
		//layui表单
		var form = layui.form;
		var laydate = layui.laydate;
		var $ = layui.$;

		//日期
		/* laydate.render({
		  elem: '#createTime'
		}); */

		//监听提交
		form.on('submit(itemForm)', function(data) {
			//layer.msg(JSON.stringify(data));
		});
	});
</script>
</html>