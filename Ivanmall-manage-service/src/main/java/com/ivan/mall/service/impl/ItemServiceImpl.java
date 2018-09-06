package com.ivan.mall.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivan.mall.mapper.ItemDao;
import com.ivan.mall.pojo.Item;
import com.ivan.mall.service.ItemService;
import com.ivan.mall.service.PictureService;

/**
 * 查询商品的Service接口实现类
 * @author Ivan
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	//注入ItemDao
	@Autowired
	private ItemDao itemDao;
	//注入PictureService
	@Autowired
	private PictureService pictureService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//根据商品id查询商品信息
	@Override
	public Item getItemById(long id) {
		return itemDao.getItemById(id);
	}

	//查询所有商品信息--分页查询
	@Override
	public List<Item> getItemList() {
		return itemDao.getItemList();
	}

	//添加新增商品信息
	@Override
	public void addItem(Item item) {
		String now = sdf.format(new Date());
		
		item.setCreateTime(now);//创建时间
		item.setLastChangeTime(now);//最后修改时间
		item.setDeleteFlag(1);//删除标志--初始化时未删除
		itemDao.addItem(item);
	}

	//根据id删除Item
	@Override
	@Transactional//开启事务
	public void deleteItem(Long id) {
		
		//根据商品id获取图片远程地址
		String picUrl = itemDao.getPicUrl(id);
		//图片服务器上不存在该图片
		if (picUrl != null && picUrl != "") {
			//删除ftp服务器中的图片
			pictureService.deleteFile(picUrl);
		}
		
		//删除数据库中的相应信息--假删除(deleteFlag = 0, 图片picURL置为null)
		itemDao.deleteImage(id);
	}

	//编辑商品信息
	@Override
	public void updateItem(Item item) {
		item.setLastChangeTime(sdf.format(new Date()));
		itemDao.updateItem(item);
	}
	
}
