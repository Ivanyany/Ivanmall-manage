package com.ivan.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

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
}
