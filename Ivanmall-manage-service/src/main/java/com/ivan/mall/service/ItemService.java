package com.ivan.mall.service;

import java.util.List;

import com.ivan.mall.pojo.Item;

/**
 * 查询商品的Service接口
 * @author Ivan
 *
 */

public interface ItemService {
	//根据商品id查询商品信息
	Item getItemById(long id);

	//查询所有商品信息--分页查询
	List<Item> getItemList();
}
