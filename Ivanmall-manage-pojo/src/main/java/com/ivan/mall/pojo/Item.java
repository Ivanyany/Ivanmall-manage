package com.ivan.mall.pojo;

import java.util.Date;

/**
 * 商品实体类
 * @author Ivan
 *
 */

public class Item {
	
	private Long id;//商品id
	private String name;//商品名称
	private Integer price;//商品价格
	private String pictureUrl;//商品图片,数据库中存放的是地址
	private String description;//商品描述
	private String createTime;//创建时间
	private String lastChangeTime;//最后修改时间
	private Integer cid;//商品分类id
	private Category category;//商品所属分类
	private int deleteFlag;//删除标志:0表示已删除,1表示未删除
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastChangeTime() {
		return lastChangeTime;
	}
	public void setLastChangeTime(String lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", pictureUrl=" + pictureUrl
				+ ", description=" + description + ", createTime=" + createTime + ", lastChangeTime=" + lastChangeTime
				+ ", cid=" + cid + ", category=" + category + ", deleteFlag=" + deleteFlag + "]";
	}
}
