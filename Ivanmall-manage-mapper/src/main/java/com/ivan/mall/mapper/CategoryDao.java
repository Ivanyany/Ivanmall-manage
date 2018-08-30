package com.ivan.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ivan.mall.pojo.Category;

/**
 * 商品分类的dao
 * @author Ivan
 *
 */

public interface CategoryDao {

	//查询所有商品类别
	@Select("select id, name, createTime, lastChangeTime from ivanmall_category where deleteFlag = 1")
	List<Category> getCategoryList();

	//添加商品分类
	@Insert("insert into ivanmall_category(name, createTime, lastChangeTime, deleteFlag) values(#{name}, #{createTime}, #{lastChangeTime}, #{deleteFlag})")
	void addCategory(Category category);

	//根据id删除Category   假删除--deleteFlag = 0
	@Update("update ivanmall_category set deleteFlag = 0 where id = #{id}")
	void deleteCategory(Integer id);

	//编辑商品分类
	@Update("update ivanmall_category set name = #{name}, lastChangeTime = #{lastChangeTime}  where id = #{id}")
	void updateCategory(Category category);
}
