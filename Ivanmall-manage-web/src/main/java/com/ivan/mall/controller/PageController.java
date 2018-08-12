package com.ivan.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 * @author Ivan
 *
 */
@Controller
public class PageController {

	//打开后台管理首页
	@RequestMapping("/")
	public String openIndex() {
		return "backstate/index";
	}
	
	//展示后台其他页面
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return "backstate/" + page;
	}
}
