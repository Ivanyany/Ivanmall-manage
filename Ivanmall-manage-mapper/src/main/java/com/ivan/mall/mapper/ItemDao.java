package com.ivan.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ivan.mall.pojo.Item;

/**
 * 商品Mapper接口
 * @author Ivan
 *
 */

public interface ItemDao {

	//根据商品id查询商品信息
	@Select("select id, name, price, pictureUrl, description, createTime, lastChangeTime, cid from ivanmall_item where id = #{id} and deleteFlag = 1")
	Item getItemById(long id);

	//查询所有商品信息--分页查询
	@Select("select id, name, price, pictureUrl, description, createTime, lastChangeTime, cid from ivanmall_item where deleteFlag = 1")
	List<Item> getItemList();

	//添加新增商品信息
	@Insert("insert into ivanmall_item(name, price, pictureUrl, description, createTime, lastChangeTime, cid, deleteFlag) values(#{name}, #{price}, #{pictureUrl}, #{description}, #{createTime}, #{lastChangeTime}, #{cid}, #{deleteFlag})")
	void addItem(Item item);

	//根据商品id获取图片名称
	@Select("select pictureUrl from ivanmall_item where id = #{id}")
	String getPicUrl(Long id);

	//删除数据库中的相应信息
	@Update("update ivanmall_item set pictureUrl = null, deleteFlag = 0 where id = #{id}")
	void deleteImage(Long id);

	//编辑商品信息
	@Update("update ivanmall_item set name = #{name}, price = #{price}, pictureUrl = #{pictureUrl}, description = #{description}, lastChangeTime = #{lastChangeTime}, cid = #{cid} where id = #{id}")
	void updateItem(Item item);
}
