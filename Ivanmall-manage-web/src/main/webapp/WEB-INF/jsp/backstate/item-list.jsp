<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
</div>
</body>
<script type="text/html" id="barOp">
  <!-- <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a> -->
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
layui.use('table', function(){
  var table = layui.table;
  //引入jquery
  var $ =layui.jquery;
  
  //table实例
  renderTable();
  
  //table表格初始化
  function renderTable() {
	  table.render({
		    elem: '#itemTable'
		    ,height: 500
		    //,width: 1000
		    ,url: '/item/list' //数据接口
		    ,limits: [10, 15, 20]
		    ,page: true //开启分页
		    ,cols: [[
		        {type:'checkbox', width:'4%'}
		        //,{field:'id', width:80, title: 'ID', sort: true}
		        ,{field:'name', width:'10%', title: '商品名称'}
		        ,{field:'price', width:'10%', title: '商品价格', sort: true}
		        ,{field:'pictureUrl', width:'22%', title: '图片路径'}
		        ,{field:'description', width:'22%', title: '商品描述'}
		        ,{field: 'createTime', width:'10%', title: '创建时间', sort: true}
		        ,{field:'lastChangeTime', width:'10%', title: '最后更新时间', sort: true}
		        ,{fixed: 'right', align:'center', width:'12%', title: '操作', toolbar: '#barOp'} //这里的toolbar值是模板元素的选择器
		      ]]
		  });
  }
  
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
      layer.confirm('确定要删除吗？', function(index){
        //obj.del();
        //layer.close(index);
        $.ajax({
          url: "<c:url value='/delItem/'/>" + data.id,
          type: "DELETE",
          success: function(result) {
        	  layer.msg(result.msg);
        	  renderTable();
          }
        });
      });
    } else if(obj.event === 'edit'){
      //layer.alert('编辑行：<br>'+ JSON.stringify(data))
      //上述条件符合之后,弹出提现弹窗
      layui.use('layer', function() {
          var layer = layui.layer;
          var form = layui.form;
          var index = layer.open({
              type: 2,
              skin: 'layui-layer-molv',
              title: '商品编辑',
              maxmin: true, //开启最大化最小化按钮
              shadeClose: true, //点击遮罩关闭
              content:["<c:url value='/item-edit'/>",'no'] ,//不允许出现滚动条
              area:['900px', '650px'],
              success : function(layero, index){
                  var body = layui.layer.getChildFrame('body', index);
                  // 取到弹出层里的元素，并把编辑的内容放进去
                  body.find("#id").val(data.id);  //将选中的数据的id传到编辑页面的隐藏域，便于根据ID修改数据
                  body.find("#name").val(data.name);  //密码
                  body.find("#price").val(data.price);  //登录时间
                  body.find("#descriptionTxtArea").val(data.description);  //登录名
                  // 记得重新渲染表单
                  form.render();
              }
          });
      });
    }
  });

  //时间戳转时间
  /* function format(datetime, fmt) {
	if (parseInt(datetime)==datetime) {
		if (datetime.length==10) {
			datetime=parseInt(datetime)*1000;
		} else if(datetime.length==13) {
			datetime=parseInt(datetime);
		}
	}
	datetime=new Date(datetime);
	var o = {
	"M+" : datetime.getMonth()+1,                 //月份   
	"d+" : datetime.getDate(),                    //日   
	"h+" : datetime.getHours(),                   //小时   
	"m+" : datetime.getMinutes(),                 //分   
	"s+" : datetime.getSeconds(),                 //秒   
	//"q+" : Math.floor((datetime.getMonth()+3)/3), //季度   
	//"S"  : datetime.getMilliseconds()             //毫秒   
	};   
	if(/(y+)/.test(fmt))   
	fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));   
	for(var k in o)   
	if(new RegExp("("+ k +")").test(fmt))   
	fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	return fmt;
  } */
  
});
</script>
</html>