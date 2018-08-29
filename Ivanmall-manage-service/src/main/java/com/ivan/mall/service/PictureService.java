package com.ivan.mall.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传图片的service
 * @author Ivan
 *
 */

public interface PictureService {

	//上传图片,返回Map
	Map uploadPicture(MultipartFile uploadFile);

	//删除ftp服务器中的图片
	boolean deleteFile(String picUrl);
	
}
