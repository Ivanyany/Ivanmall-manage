package com.ivan.mall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ivan.mall.pojo.Category;
import com.ivan.mall.pojo.Message;
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
	
	@ResponseBody
	@RequestMapping("/getCategoryList")
	public Message getCategoryList() {
		List<Category> categoryList = categoryService.getCategoryList();
		Message message = Message.build(200, "查询成功...");
		message.setData(categoryList);
		return message;
	}
	
	//查询所有商品类别--分页查询
	@ResponseBody
	@RequestMapping("/category/list")
	public Message getCategoryListByPage(@RequestParam("page")Integer page, @RequestParam("limit")Integer limit) {
		
		//page:页码--layui默认的参数
		//limit:每页查询的记录数--layui默认的参数
		//分页插件pageHelper
		PageHelper.startPage(page, limit);
		List<Category> categoryList = categoryService.getCategoryList();
		PageInfo pageInfo = new PageInfo(categoryList);
		Message message = Message.build(0, "查询成功...");
		message.setData(categoryList);
		message.setCount(pageInfo.getTotal());
		return message;
	}
	
	//添加商品分类
	@RequestMapping("/addCategory")
	public void addCategory(Category category, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//调用service方法,添加新增商品信息
		categoryService.addCategory(category);//添加商品分类

		//重定向至查询数据
		request.getRequestDispatcher("/category-list").forward(request, response);
	}
	
	//删除商品分类	
	@RequestMapping(value="/delCategory/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public Message deleteCategory(@PathVariable("id")Integer id) {
		//删除Category
		categoryService.deleteCategory(id);//根据id删除Category
		
		return Message.build(200, "删除成功...");
	}
	
	//编辑商品分类
	@RequestMapping("/editCategory")
	@ResponseBody
	public Message editCategory(Category category) {
		//编辑商品分类
		categoryService.updateCategory(category);
		
		return Message.build(200, "编辑成功...");
	}
}
