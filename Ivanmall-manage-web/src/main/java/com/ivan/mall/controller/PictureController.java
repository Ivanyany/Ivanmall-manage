package com.ivan.mall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivan.mall.service.PictureService;

/**
 * 图片上传的controller
 * @author Ivan
 *
 */
@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;
	
	//图片上传
	@RequestMapping("/picture/upload")
	@ResponseBody
	public String pictureUpload(@RequestParam("file")MultipartFile uploadFile) throws JsonProcessingException {
		Map resultMap = pictureService.uploadPicture(uploadFile);
		
		//为了保证兼容性,将map转换成json字符串
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(resultMap);
		return jsonString;
		
	}
}
