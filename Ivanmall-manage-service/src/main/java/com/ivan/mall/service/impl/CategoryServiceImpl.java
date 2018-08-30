package com.ivan.mall.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
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
	
	//时间格式化
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//查询所有商品类别
	@Override
	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	//添加商品分类
	@Override
	public void addCategory(Category category) {
		String now = sdf.format(new Date());
		
		category.setCreateTime(now);//创建时间
		category.setLastChangeTime(now);//最后修改时间
		category.setDeleteFlag(1);//删除标志--初始化时未删除
		
		categoryDao.addCategory(category);
	}

	//根据id删除Category
	@Override
	public void deleteCategory(Integer id) {
		categoryDao.deleteCategory(id);
	}

	//编辑商品分类
	@Override
	public void updateCategory(Category category) {
		category.setLastChangeTime(sdf.format(new Date()));
		categoryDao.updateCategory(category);
	}

}
