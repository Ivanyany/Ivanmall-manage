package com.ivan.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.mall.mapper.ItemDao;
import com.ivan.mall.pojo.Item;
import com.ivan.mall.service.ItemService;

/**
 * 查询商品的Service接口实现类
 * @author Ivan
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	//注入ItemDao
	@Autowired
	private ItemDao itemDao;

	//根据商品id查询商品信息
	@Override
	public Item getItemById(long id) {
		return itemDao.getItemById(id);
	}

	//查询所有商品信息--分页查询
	@Override
	public List<Item> getItemList() {
		return itemDao.getItemList();
	}
	
}
