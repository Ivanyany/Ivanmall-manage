package com.ivan.mall.service;

import com.ivan.mall.pojo.Item;

/**
 * 查询商品的Service接口
 * @author Ivan
 *
 */

public interface ItemService {
	//根据商品id查询商品信息
	Item getItemById(long id);
}
