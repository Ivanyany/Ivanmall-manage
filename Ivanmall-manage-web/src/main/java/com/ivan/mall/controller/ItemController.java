package com.ivan.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivan.mall.pojo.Item;
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
}
