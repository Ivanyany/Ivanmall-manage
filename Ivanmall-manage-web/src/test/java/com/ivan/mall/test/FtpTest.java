package com.ivan.mall.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * 测试ftp文件服务器
 * 
 * @author Ivan
 *
 */

public class FtpTest {

//	@Test
//	public void testFTP() throws SocketException, IOException {
//		// 创建一个FTPClient对象
//		FTPClient ftpClient = new FTPClient();
//		// 创建ftp连接,默认21端口
//		ftpClient.connect("192.168.0.184", 21);
//		// 登录ftp服务器:使用匿名用户登录,密码为空
//		ftpClient.login("ftpuser", "ftpuser");
//		// ******************上传文件*******************
//		// 读取本地文件
//		FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\Ivan.jpg"));
//		// 设置上传的路径
//		ftpClient.changeWorkingDirectory("/home/wwwroot/ivanmall" + "/images");
//		// 设置上传文件的格式:二进制
//		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//		// 上传至ftp服务器:
//		ftpClient.storeFile("Ivan.jpg", inputStream);//第一个参数:上传ftp服务器的文件名,第二个参数:上传文件的IO流
//		// 关闭连接
//		ftpClient.logout();
//	}
}
