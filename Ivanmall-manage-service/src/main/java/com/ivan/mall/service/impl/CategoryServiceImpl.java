package com.ivan.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.mall.mapper.CategoryDao;
import com.ivan.mall.pojo.Category;
import com.ivan.mall.service.CategoryService;

/**
 * CategoryService的实现类
 * @author Ivan
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	//注入dao
	@Autowired
	private CategoryDao categoryDao;

	//查询所有商品类别
	@Override
	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

}
