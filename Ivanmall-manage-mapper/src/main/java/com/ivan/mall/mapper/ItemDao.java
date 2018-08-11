package com.ivan.mall.mapper;

import org.apache.ibatis.annotations.Select;

import com.ivan.mall.pojo.Item;

/**
 * 商品Mapper接口
 * @author Ivan
 *
 */

public interface ItemDao {

	@Select("select * from tb_item where id = #{id}")
	Item getItemById(long id);//id, item_name, item_price, item_description
}
