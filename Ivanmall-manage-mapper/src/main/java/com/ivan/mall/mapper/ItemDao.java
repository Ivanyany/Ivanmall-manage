package com.ivan.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ivan.mall.pojo.Item;

/**
 * 商品Mapper接口
 * @author Ivan
 *
 */

public interface ItemDao {

	//根据商品id查询商品信息
	@Select("select id, name, price, description from ivanmall_item where id = #{id}")
	Item getItemById(long id);

	//查询所有商品信息--分页查询
	@Select("select id, name, price, description from ivanmall_item")
	List<Item> getItemList();
}
