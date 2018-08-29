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

}
