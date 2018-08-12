package com.ivan.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Item getItemById(@PathVariable Long itemId) {
		Item item = itemService.getItemById(itemId);
		return item;
	}
	
	//查询所有商品信息--分页查询
	@RequestMapping("/item/list")
	@ResponseBody
	public Message getItemList(@RequestParam("page")Integer page, @RequestParam("limit")Integer limit){
		//page:页码--layui默认的参数
		//limit:每页查询的记录数--layui默认的参数		
		//分页插件pageHelper
		PageHelper .startPage(page, limit);
		List<Item> itemList = itemService.getItemList();
		PageInfo pageInfo = new PageInfo(itemList);
		Message message = Message.success();
		message.setData(itemList);
		message.setCount(pageInfo.getTotal());
		return message;
		
	}
}
