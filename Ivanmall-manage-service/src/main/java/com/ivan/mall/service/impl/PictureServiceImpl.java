package com.ivan.mall.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ivan.mall.service.PictureService;
import com.ivan.mall.util.FtpUtil;
import com.ivan.mall.util.IDUtil;

/**
 * 上传图片的service的实现类
 * @author Ivan
 *
 */
@Service
public class PictureServiceImpl implements PictureService {
	// spring自动注入properties文件的值
	// FTP服务器的ip地址
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;

	// FTP服务器的端口
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;

	// FTP服务器的登录用户名
	@Value("${FTP_USER}")
	private String FTP_USER;

	// FTP服务器的登录密码
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;

	// FTP服务器的上传文件的根路径
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;

	// 图片服务器的URL
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	// 上传图片,返回Map
	@Override
	public Map uploadPicture(MultipartFile uploadFile) {
		Map resultMap = new HashMap<>();
		try {
			// 生成一个新的文件名
			// 取原文件名
			String oldName = uploadFile.getOriginalFilename();
			// 生成新文件名
			// UUID.randomUUID();
			String newName = IDUtil.getImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));

			// 图片上传——上传的路径为：根路径/images/xxxx/xx/xx(年月日)
			String imgPath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER, FTP_PASSWORD,
					FTP_BASE_PATH, "/images" + imgPath, newName, uploadFile.getInputStream());

			// 返回结果
			if (!result) {
				resultMap.put("code", -1);
				resultMap.put("msg", "File upload failed!");
				return resultMap;
			}
			resultMap.put("code", 0);
			resultMap.put("data", IMAGE_BASE_URL + imgPath + "/" + newName);
			return resultMap;
		} catch (Exception e) {
			resultMap.put("code", -1);
			resultMap.put("msg", "File upload failed:" + e.getMessage());
			return resultMap;
		}
	}

	@Override
	public boolean deleteFile(String picUrl) {
		//String picUrl = "http://106.14.124.124/images/2018/08/29/1535526070404543.jpg";
		String remotePath = picUrl.substring(0, picUrl.lastIndexOf("/"));
		remotePath = remotePath.substring(remotePath.indexOf("images") - 1);
		String fileName = picUrl.substring(picUrl.lastIndexOf("/") + 1);
		try {
			if (FtpUtil.deleteFile(FTP_ADDRESS, FTP_PORT, FTP_USER, FTP_PASSWORD, 
					FTP_BASE_PATH + remotePath, fileName)) {
				return true;
			}
		} catch (Exception e) {
			throw new RuntimeException();			
		}
		return false;
	}

}
