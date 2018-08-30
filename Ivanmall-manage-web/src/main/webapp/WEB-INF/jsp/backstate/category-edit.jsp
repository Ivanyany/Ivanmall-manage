<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>商品分类修改</title>
<link rel="stylesheet" href="<c:url value='/css/layui.css'/>">
</head>
<body class="layui-layout-body">
	<form class="layui-form layui-form-pane" id="catForm">
		<input type="hidden" name="id" id="id">
		<div class="layui-form-item">
			<label class="layui-form-label">分类名称</label>
			<div class="layui-input-block">
				<input type="text" name="name" id="name" lay-verify="required"
					placeholder="输入商品分类名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" id="updateBtn" lay-submit lay-filter="categoryForm">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
<script src="<c:url value='/js/layui.js'/>"></script>
<script>
layui.use(['layer'], function(){
		//layui表单
		var $ = layui.$;
		var layer = layui.layer;

		//表单提交
		$("#updateBtn").click(function(){
			$.ajax({
				url: "<c:url value='/editCategory'/>",
				type: "POST",
				data: $("#catForm").serialize(),
				success: function(data){
					var index = parent.layer.getFrameIndex(window.name);
					window.parent.location.reload();//刷新父页面
					layer.close(layer.index);
				}
			});
		});
	});
</script>
</html>