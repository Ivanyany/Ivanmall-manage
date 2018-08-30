package com.ivan.mall.service;

import java.util.List;

import com.ivan.mall.pojo.Category;

/**
 * 商品分类的Service
 * @author Ivan
 *
 */

public interface CategoryService {
	
	//查询所有商品类别
	List<Category> getCategoryList();

	//添加商品分类
	void addCategory(Category category);

	//根据id删除Category
	void deleteCategory(Integer id);

	//编辑商品分类
	void updateCategory(Category category);

}
