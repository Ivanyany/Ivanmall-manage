package com.ivan.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivan.mall.pojo.Category;
import com.ivan.mall.service.CategoryService;

/**
 * 商品类别的controller
 * @author Ivan
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//查询所有商品类别
	@ResponseBody
	@RequestMapping("/getCategoryList")
	public List<Category> getCategoryList() {
		List<Category> list = categoryService.getCategoryList();
		return list;
	}
	
	//添加商品分类
	@RequestMapping("/addCategory")
	public void addCategory(Category category) {
		int i = 0;
		int j = 1;
		int k = i + j;
		System.out.println(k);
	}
	
}
