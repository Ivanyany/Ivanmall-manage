<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>商品信息编辑</title>
<link rel="stylesheet" href="<c:url value='/css/layui.css'/>">
</head>
<body class="layui-layout-body">
<!--商品信息编辑弹出层-->
<form class="layui-form"><!-- action="/editItem" method="post"  -->
	<input type="hidden" name="id" id="id">
	<div class="layui-form-item">
		<label class="layui-form-label">商品名称</label>
		<div class="layui-input-block">
			<input type="text" name="name" id="name" lay-verify="required" 
				placeholder="输入商品名称" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">商品分类</label>
		<div class="layui-input-block">
			<select name="cid" id="category" lay-verify="required">
				<option value="">请选择商品分类</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">商品价格</label>
		<div class="layui-input-block">
			<input type="text" name="price" id="price" lay-verify="required" 
				placeholder="输入商品价格" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-upload">
              <label class="layui-form-label">商品图片</label>
              <div class="layui-upload layui-input-block">
                  <input type="hidden" name="pictureUrl" lay-verify="required"/>
                  <button type="button" class="layui-btn layui-btn-primary" id="fileBtn"><i class="layui-icon">&#xe67c;</i>选择文件</button>
                  <button type="button" class="layui-btn" id="uploadBtn">开始上传</button>
              </div>
          	</div>
	<div class="layui-form-item layui-form-text">
		<label class="layui-form-label">商品描述</label>
		<div class="layui-input-block">
			<!-- <input type="hidden" name="description" value=""/> -->
			<textarea name="description" id="descriptionTxtArea" lay-verify="required" style="display: none;"></textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="itemForm" id="updateBtn">修改</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>
</body>
<script src="<c:url value='/js/layui.js'/>"></script>
<script>
	layui.use('form', function() {
		//layui表单
		var form = layui.form;
		var layer = layui.layer;
		var $ = layui.$;
		//点击商品分类下拉框,向后台服务器查询分类列表
		$.ajax({
	  	    url:'/getCategoryList',
	  	    dataType:'json',
	  	    type:'post',
	  	    success:function(data){
	  	    	
	  	    	$.each(data,function(index, item){
	  	    		$('#category').append(new Option(item.name,item.id));// 下拉菜单里添加元素
	  	    	})
				form.render();//下拉菜单渲染 把内容加载进去
	  	    }
	  	});

		//监听提交
		/* form.on('submit(itemForm)', function(data) {
			//layer.msg(JSON.stringify(data));
			//修改成功
			alert(data.code);
			if(data.code == 0){
				var index = parent.layer.getFrameIndex(window.name);
				window.parent.location.reload();//刷新父页面
				layer.close(layer.index);
			}
		}); */
		//表单提交
		$("#updateBtn").click(function(){
			$.ajax({
				url: "<c:url value='/editItem'/>",
				type: "POST",
				data: $(".layui-form").serialize(),
				success: function(data){
					var index = parent.layer.getFrameIndex(window.name);
					window.parent.location.reload();//刷新父页面
					layer.close(layer.index);
				}
			});
		});
		
		//富文本编辑器
		layui.use('layedit', function() {
			var layedit = layui.layedit;
			var index = layedit.build('descriptionTxtArea'); //建立编辑器
			//$("[name=description]").val(layedit.getContent(index));
			layedit.sync(index);
		});

		//图片上传
		layui.use('upload',function(){
            var upload = layui.upload;
            upload.render({
                elem: '#fileBtn'
                ,url: '/picture/upload' //上传接口
                ,accept: 'file'
                ,auto: false
                ,bindAction: '#uploadBtn'
                ,done: function(res){
                    //console.log(res);
                    //alert("已上传至FTP文件服务器,图片地址为:\n" + res.data);
                    if(res.code == -1){
                    	layer.msg("图片上传失败，请重新上传");
                    } else{
                    	layer.msg("已上传至FTP文件服务器,图片地址为:\n" + res.data);
                        $("[name=pictureUrl]").val(res.data);
                    }
                }
            });
        });
	});
</script>
</html>