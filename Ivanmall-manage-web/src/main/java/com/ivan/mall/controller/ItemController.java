package com.ivan.mall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ivan.mall.pojo.Item;
import com.ivan.mall.pojo.Message;
import com.ivan.mall.service.ItemService;



/**
 * ItemController
 * @author Ivan
 *
 */
@Controller
public class ItemController {
	
	//注入ItemService
	@Autowired
	private ItemService itemService;
	
	//根据商品id查询商品信息
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public Message getItemById(@PathVariable("itemId")Long itemId) {
		Item item = itemService.getItemById(itemId);
		
		Message message = new Message().success();
		message.setData(item);
		return message;
	}
	
	//查询所有商品信息--分页查询
	@RequestMapping("/item/list")
	@ResponseBody
	public Message getItemList(@RequestParam("page")Integer page, @RequestParam("limit")Integer limit){
		//page:页码--layui默认的参数
		//limit:每页查询的记录数--layui默认的参数		
		//分页插件pageHelper
//		PageHelper.startPage(page, limit);
//		List<Item> itemList = itemService.getItemList();
//		PageInfo pageInfo = new PageInfo(itemList);
//		Message message = Message.success("分页查询成功");
//		message.setData(itemList);
//		message.setCount(pageInfo.getTotal());
//		return message;
		return getItemByPage(page, limit);
	}
	
	/**
	 * 分页查询Item数据
	 * @param page:页码--layui默认的参数
	 * @param limit:每页查询的记录数--layui默认的参数
	 * @param msg:操作结果信息
	 * @return
	 */
	public Message getItemByPage(Integer page, Integer limit) {
		//开启分页插件pageHelper
		PageHelper.startPage(page, limit);
		//查询数据
		List<Item> itemList = itemService.getItemList();
		//封装数据到分页对象
		PageInfo pageInfo = new PageInfo(itemList);
		
		//返回操作信息对象
		Message message = Message.success();
		//设置操作信息对象信息
		message.setData(itemList);
		message.setCount(pageInfo.getTotal());
		return message;
	}
	
	//添加商品信息
	@RequestMapping("/addItem")
	public void addItem(Item item, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//调用service方法,添加新增商品信息
		itemService.addItem(item);//添加新增商品信息

		//重定向至查询数据
		request.getRequestDispatcher("/item-list").forward(request, response);
	}
	
	//删除商品信息	
	@RequestMapping(value="/delItem/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public Message deleteItem(@PathVariable("id")Long id) {
		//删除Item
		itemService.deleteItem(id);//根据id删除Item
		Message message = new Message().success();
		message.setMsg("删除成功...");
		
		return message;
	}
	
	//编辑商品
	@RequestMapping("/editItem")
	@ResponseBody
	public Message editItem(Item item, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编辑商品信息
		itemService.updateItem(item);
		
		Message message = new Message().success();
		
		return message;
	}
}
